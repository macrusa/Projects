package model;

import message.ISubscriber;
import message.Message;

public class Chord implements ISubscriber
{

  private SoundBank _soundBank;
  private boolean[] _notes;

  public Chord(SoundBank soundBank, int numNotes)
  {
    _soundBank = soundBank;
    _notes = new boolean[numNotes];
  }

  @Override
  public void notify(Message message)
  {
    this.play();
  }

  public void play()
  {
    _soundBank.play(_notes);
  }

  public void setNote(int noteNumber, boolean noteValue)
  {
//	  System.out.println("Chord.setNote noteNumber = " + noteNumber);
    _notes[noteNumber] = noteValue;
  }

}
