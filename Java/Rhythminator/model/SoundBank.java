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
