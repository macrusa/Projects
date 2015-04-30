#include <avr/io.h>
#include <util/delay.h>                     /* Functions to waste time */
#include "Speaker.h"
#include "pinDefines.h"


 char fromCompy;                        /* used to store serial input */
  const uint8_t keys[] = { 'a', 'w', 's', 'e', 'd', 'f', 't',
    'g', 'y', 'h', 'j', 'i', 'k', 'o',
     'l', 'p', ';', '\''
  };
  

  const uint16_t notes[] = { G4, Gx4, A4new, Ax4, B4, C5, Cx5,
    D5, Dx5, E5, F5, Fx5, G5, Gx5,
    A5new, Ax5, B5, C6
  };
  uint8_t isNote;
  uint8_t i;


void initSpeakers()
{
 SPEAKER_DDR |= (1 << SPEAKER);  
}

void reloadSound()
{
     playNote('e',NOTE_DURATION/2);
     rest(NOTE_DURATION/2);
     playNote('e',NOTE_DURATION/2);
}

void shootSound()
{
  playNote('k',NOTE_DURATION/3);
}

void hitSound()
{
  playNote('d',0xF000);
  playNote('a',0xF000);
}

void startGameSound(){
  playNote('l',0xF000);
  playNote('s',0xF000);
}

void gameOverSound(){
  playNote('p',0xF000);
  playNote('o',0xF000);
  playNote('k',0xF000);
  playNote('i',0xF000);
  playNote('h',0xF000);
  playNote('g',0xF000);
  playNote('t',0xF000);
  playNote('f',0xF000);
  playNote('d',0xF000);
  playNote('w',0xF000);
  playNote('a',0xF000);
}

void playNote(uint16_t wavelength, uint16_t duration) {
  uint16_t elapsed;
  uint16_t i;
  for (elapsed = 0; elapsed < duration; elapsed += wavelength) {
                     /* For loop with variable delay selects the pitch */
    for (i = 0; i < wavelength; i++) {
      _delay_us(1);
    }
    SPEAKER_PORT ^= (1 << SPEAKER);
  }
}

void rest(uint16_t duration) {
  do {
    _delay_us(1);
  } while (--duration);
}


