#include <avr/io.h>
#include <util/delay.h>                     /* Functions to waste time */
#include <avr/interrupt.h>
#include "IR.h"
#define DEBOUNCE_TIME  1000                            /* microseconds */


void setupIR(void)
{
  DDRB &= ~(1 << PB2);
  DDRD |= (1 << PD5);
}

void transmit38(void)
{
  TCCR0A = 0b00010010;
  TCCR0B = 0b00000001;
  OCR0A = 12;                        
}

void transmitLow(void)              
{
  TCCR0A |= (1 << WGM00);             /* Fast PWM mode */
  TCCR0A |= (1 << WGM01);             /* Fast PWM mode, pt.2 */
  TCCR0B |= (1 << CS01);              /* PWM Freq = F_CPU/8/256 */
  TCCR0A &= ~(1 << COM0A1);           /* PWM output on OCR0A */
}

void transmitPlayer1()
{
  transmit38();
  _delay_ms(2);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);
}

void transmitPlayer2()
{
  transmit38();
  _delay_ms(2);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);

  transmitLow();
  _delay_ms(1);
  transmit38();
  _delay_ms(1);
}

//external interrupt falling edge on PD2
void initReceiverInterrupt(void) {
  EIMSK |= (1 << INT0);
  EICRA |= (1 << ISC01);                    //Falling edge on INT0 (Pin PD2)
}

//Timer1 to count packet length
void initTimer1Receiver(void) {
  TCCR1A = 0b00000000;                      //Normal Mode, no waveform gen
  TCCR1B = (1 << CS10);                     //clk/1 prescaling
}

int decodeMessage(int count, uint8_t timerL, uint8_t timerH) {
  printString("# of falling edges: ");
  printByte(count);
  printString(", timer high: ");
  printByte(timerH);
  printString(", timer low ");
  printByte(timerL);
  printString(" ");
  if (timerH > 80) {  // packet length

    TCCR1B &= ~(1 << CS12);   //disable timer1 & reset
    TCCR1B &= ~(1 << CS11);
    TCCR1B &= ~(1 << CS10);
    TCNT1L = 0;
    TCNT1H = 0;
    printString("Disable Timer 1 \n");
    if (count == 3) {  //player 1 message
      printString("Message1 \n");
      return 1;
    }
    else if (count == 6) { //player 2 message
      printString("Message2 \n");
      return 2;
    }
    else {                   //ambiguous message
      printString("Amb Message \n");
      return -1;
    }
  }
  else {
    printString("No Message \n");    //no message received
    return 0;
  }
}
