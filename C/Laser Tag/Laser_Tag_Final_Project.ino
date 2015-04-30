#include <avr/io.h>
#include <util/delay.h>                     /* Functions to waste time */
#include <avr/interrupt.h>
#define F_CPU  1000000L
#define BAUD  9600
#include "USART.c"
//#include "USART.h"
#include "IR.c"
#include "IR.h"
#include "Button.c"
#include "Button.h"
#include "Speaker.c"
#include "Speaker.h"
#include "pinDefines.h"

volatile int pulsecount = 0;
volatile int health = 10;
volatile int ammo = 10;
volatile int transMessage = 0;

//trigger when receiver goes low, will trigger multiple times to count pulses

ISR(INT0_vect) {
  printString("IN ISR \n");

  if (TCNT1L  < 1) { //only start timer1 if disabled
    printString("Start Timer 1\n");
    initTimer1Receiver();
    TCNT1L = 0;
    TCNT1H = 0;
  }
  pulsecount++;
  transMessage = decodeMessage(pulsecount, TCNT1L, TCNT1H);
}

ISR(PCINT0_vect)          //Shoot PB5
{
  if (debounce(PINB, PB5))
  {
    if (bit_is_clear(PINB, PB5))
    {
      printString("Button pushed shot: \n");
      //shoot();
      shootSound();
      ammo--;
      printString("Ammo: ");
      printByte(ammo);
    }
  }
}

ISR(PCINT2_vect)          //Reload PD4
{
  if (debounce(PIND, PD4))
  {
    if (bit_is_clear(PIND, PD4))
    {
      printString("Button pushed reload: \n ");
      reloadSound();
      ammo = 10;
    }
  }
}




//function initialize Hit LED
void intializeHitLED(void) {
  DDRC |= (1 << PC5);
}

//function takeHit()
void takeHit(void) {
  if (transMessage == 2) {    // <------------------------------ changed for each player
    health--;

    hitSound();
    PORTC |= (1 << PC5);
    _delay_ms(500);
    PORTC &= ~(1 << PC5);
    //update 7 segment
    transMessage = 0;
  }
}

//function gameOverCheck()
void gameOverCheck(void) {
  if (health <= 0)
  {
    PORTC |= (1 << PC5);
    gameOverSound();

    while (1 > 0) {
      //lol
    }
  }
}


int main(void)
{
  // -------- Inits --------- //
  initReceiverInterrupt();
  setupIR();
  sei();
  initUSART();
  initButton();
  initShootInterrupt();
  initReloadInterrupt();
  initSpeakers();
  intializeHitLED();
  startGameSound();
  // ------ Event loop ------ //
  while (1)
  {
    //printString("\nStart: \n");
    pulsecount = 0;
    transmitPlayer2();
    transmitLow();
    _delay_ms(20);

    takeHit();
    gameOverCheck();
  }
  /* End event loop */
  return (0);                            /* This line is never reached */
}
