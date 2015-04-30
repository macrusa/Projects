//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package model;

public class SoundBank
{

	private Sound[] _sounds;

	public SoundBank(Sound[] sounds)
	{
		_sounds = sounds;
	}

	public void play(boolean[] noteValues)
	{
		for(int n=0; n<noteValues.length; n++)
			if(noteValues[n])
			{
				Sound sound = _sounds[n];
				if(sound != null)
					_sounds[n].play();
			}
	}

	public void play(int soundNumber)
	{
		_sounds[soundNumber].play();
	}

	public void setSound(int soundNumber, Sound sound)
	{
		_sounds[soundNumber] = sound;
	}

	
	public Sound[] getSounds()
	{
		return _sounds;
	}

}
