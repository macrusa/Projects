//black 230-240
//40-220
//252 air

#include <avr/io.h>
#include <util/delay.h>

int left, mid, right;                                     /* Left, Mid, Right sensor values */

//ADC FUNCTIONS
static inline void initFreerunningADC(void)               /* Freerunning ADC setup */
{
  ADMUX |= (1 << REFS0);                                  /* reference voltage on AVCC */
  ADCSRA |= (1 << ADPS1) | (1 << ADPS0) | (1 << ADIE);    /* ADC clock prescaler /8 */
  ADMUX |= (1 << ADLAR);                                  /* left-adjust result, return only 8 bits */
  ADCSRA |= (1 << ADEN);                                  /* enable ADC */
  //ADCSRA |= (1 << ADATE);                               /* auto-trigger enable */
}
static inline void adc3left(void)
{
  ADMUX = ADMUX & 0b11100000;                             /* 7, 6: internal 1.1V ref with external cap at AREF pin, 5: ADC Left Adjuist Result */
  ADMUX |=  (1 << MUX1) | (1 << MUX0);                    /* ADC3 MUX 0011*/
  ADCSRA |= (1 << ADSC);                                  /* ADC Start Conversion */
  _delay_ms(20);
  left = ADCH;                                            /* ADC Data Register */
}
static inline void adc6mid(void)
{
  ADMUX = ADMUX & 0b11100000;
  ADMUX |=  (1 << MUX2) | (1 << MUX1) ;                   /* ADC6 MUX 0110 */
  ADCSRA |= (1 << ADSC);                                  /* ADC Start Conversion */
  _delay_ms(20);
  mid = ADCH;                                             /* ADC Data Register */
}
static inline void adc7right(void)
{
  ADMUX = ADMUX & 0b11100000;
  ADMUX |=  (1 << MUX2) | (1 << MUX1) | (1 << MUX0);      /* ADC7 MUX 0111 */
  ADCSRA |= (1 << ADSC);                                  /* ADC Start Conversion */
  _delay_ms(20);
  right = ADCH;                                           /* ADC Data Register */
}

//PWM FUNCTIONS
static inline void initTimers(void)                       /* PWM Timer0 setup */
{
  //Timer 0 A,B
  TCCR0A |= (1 << WGM00);                                 /* Fast PWM mode */
  TCCR0A |= (1 << WGM01);                                 /* Fast PWM mode, pt.2 */
  TCCR0B |= (1 << CS02) | (1 << CS00);                    /* PWM Freq = F_CPU/1024/256 */
  TCCR0A |= (1 << COM0A1);                                /* PWM output on OCR2A */
}

/* Left: (PD2, PD4), Right: (PD7, PB0) */
void driveForward(int speed)                              /* Left: HL (PD2, PD4), Right: HL (PD7, PB0) */
{ 
  OCR0A = speed;                                          /* Left wheel speed */
  OCR0B = speed;                                          /* Right wheel speed */
  PORTD = 0b01101111;                                     /* Left wheel PD2: H, PD4: L --> Forward */
  PORTB = 0b00000001;                                     /* Right wheel PD7: H, PB0: L --> Forward*/
}                                                         

void turnLeft(int speed)                                  /* Left: LH (PD2, PD4), Right: HL (PD7, PB0) */
{
  OCR0A = speed;                                          /* Left wheel speed */
  OCR0B = speed;                                          /* Right wheel speed */
  PORTD = 0b01111011;                                     /* Left wheel PD2: L PD4: H --> Reverse */
  PORTB = 0b00000001;                                     /* Right wheel PD7: H, PB0: L --> Forward*/
}

void turnRight(int speed)                                 /* Left: LH (PD2, PD4), Right: LH (PD7, PB0) */
{
  OCR0A = speed;                                          /* Left wheel speed */
  OCR0B = speed;                                          /* Right wheel speed */
  PORTD = 0b11101111;                                     /* Left PD2: L, PD4: H --> Reverse */
  PORTB = 0b00000000;                                     /* Right PD7: H, PB0: L --> Forward */
}

void stop()                                                /* Just cut the speed to both L,R wheels */
{
  OCR0A = 0;                                               /* Left wheel speed */
  OCR0B = 0;                                               /* Right wheel speed */
}    

void reverse(int speed)                                    /* Left: LH (PD2, PD4), Right: LH (PD7, PB0) */
{
  OCR0A = speed;                                           /* Left wheel speed */
  OCR0B = speed;                                           /* Right wheel speed */
  PORTD = 0b01111011;                                      /* Left PD2: L, PD4: H --> reverse */
  PORTB = 0b00000001;                                      /* Right PD7: L, PB0: H --> reverse */
}  


int main(void)                                             /* Main function */
{                                                          /* 0 input, 1 output */
  DDRC = 0b00000000;                                       /* Data-Direction register C */
  DDRD = 0b11111111;                                       /* Data-Direction register D */
  DDRB  = 0b00000001;                                      /* Data-Direction register B  */

  Serial.begin(9600);
  initFreerunningADC();                                    /* ADC setup */
  initTimers();                                            /* PWM setup */

  while (1)
  {
    adc3left();                                            /* Left sensor value */
    adc6mid();                                             /* Mid sensor value */
    adc7right();                                           /* Right sensor value */

    // These are just tests to see what the left, middle, right sensors are reading
    Serial.print("Left: ");
    Serial.print(left);
    Serial.print(" Middle: ");
    Serial.print(mid);
    Serial.print(" Right: ");
    Serial.println(right);

    //Algorithm for following black line here
    if (left > 240 && mid > 240 && mid > 240)              /* Avoids spinning the air (240-255) */
    {
      stop();
      Serial.println("STOP");
    }
    else if (left > 180)                                   /* Senses if left is on black */
    {
      int leftDiff = abs(left - mid);                      /* We take the absolute value of the diff. btw. left and middle sensors */

      if (leftDiff < 10)                                   /* In case of right angle turn left, we turn sharp left by 170 */
      {
        turnLeft(170);                                     /* We turn a sharper turn left to compensate for a sharp right angle */
        Serial.println("SHARP LEFT! <<<<<<<<<<<<<<");
      }
      else
      {
        turnLeft((leftDiff * .4) + 20);                    /* Magic algorithm through trial and error */
        Serial.print("LEFT by ");
        Serial.println(leftDiff);
      }
    }

    else if (right > 180)                                  /* Right sensor is on black */
    {
      int rightDiff = abs(right - mid);                    /* Absolute value diff. btw. right and middle sensors */
      if (rightDiff < 10)                                  /* Accounts for sharp right turns */
      {
        turnRight(170);                                    /* Turn sharply right by 170 */
        Serial.println("SHARP RIGHT!>>>>>>>>>>>>>>");
      }
      else
      {
        turnRight((rightDiff * 0.4) + 20);                /* Magic algorithm fo radjusting right */
        Serial.print("RIGHT by ");                        /* Useful debugging */
        Serial.println(rightDiff);
      }

    }
    else                                                  /* Drive forwards */
    {
      driveForward(130);                                  /* Drive forwards with 130 */
      Serial.println("FORWARDS^^^^^^^^^^^^^^");
    }
  }                                                       /* End event loop */
  return (0);                                             /* This line is never reached */
}
