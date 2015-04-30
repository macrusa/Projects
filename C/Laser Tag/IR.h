/* Functions for IR: transmitting, receiving, decoding */

void setupIR(void);

void transmit38(void);

void transmitLow(void);

void transmitPlayer1();

void transmitPlayer2();

void initReceiverInterrupt(void);

void initTimer1Receiver(void);

//returns 0, 1 or 2 based on message received
int decodeMessage(int pulsecount, uint8_t timerL, uint8_t timerH);
