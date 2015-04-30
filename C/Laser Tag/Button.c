#include <avr/io.h>
#include <util/delay.h>                     /* Functions to waste time */
#include "Button.h"
#define DEBOUNCE_TIME 50


void initButton(void)
{
  DDRB &= ~(1 << PB5);
  PORTB |= (1 << PB5);
  DDRD &= ~(1 << PD4);
  PORTD |= (1 << PD4);
  //MCUCR |= (1 << PUD);
}

void initShootInterrupt(void)
{
  PCICR |= (1 << PCIE0);                      /* Pin change interrupt PCINT5 */
  PCMSK0 |= (1 << PCINT5);
}

void initReloadInterrupt(void)
{
  PCICR |= (1 << PCIE2);                      /* Pin change interrupt PCINT20 */
  PCMSK2 |= (1 << PCINT20);
}

uint8_t debounce(uint8_t PIN, uint8_t BUTTON)
{
  if (bit_is_clear(PIN, BUTTON))
  {
    _delay_us(DEBOUNCE_TIME);
    if (bit_is_clear(PIN, BUTTON))
    {
      return (1);
    }
  }
  return (0);
}

void shoot(void) 
 {
  //transmitPlayer1();        //<--------------------------- change for player
  transmitPlayer2();
}
