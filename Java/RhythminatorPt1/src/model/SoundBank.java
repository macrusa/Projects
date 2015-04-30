//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package model;

/**
 * The class SoundBank stores Sound instances and generates Chord instances.
 */
public class SoundBank 
{
	/**
	 * Takes a Sound array and stores it into a member variable
	 * @param sounds. Takes a Sound array.
	 */
	Sound[] _sounds;
	public SoundBank(Sound[] sounds)
	{
		_sounds = sounds;
	}

	/**
	 * Takes a boolean array and returns a Chord instance that represents the sounds
	 * from the sound bank in the locations indicated by the array.
	 * @param soundFlags. Takes a boolean array.
	 */
	public Chord chord(boolean[] soundFlags)
	{
		int _sizeArray = 0;

		for(int booindex = 0; booindex < soundFlags.length; booindex++)
		{
			if(soundFlags[booindex] == true)
			{
				_sizeArray++;
			}
		}
		Sound[] soundArray = new Sound[_sizeArray];
		int arrayIndex = 0;
		for(int booindex = 0; booindex < soundFlags.length; booindex++)
		{
			if(soundFlags[booindex] == true)
			{
				soundArray[arrayIndex] = _sounds[booindex];
				arrayIndex++;
			}
		}
		Chord booleanChord = new Chord(soundArray);
		return booleanChord;
	}

	/**
	 * Takes a integer array and returns a Chord instance that represents the sounds
	 * Creates a new sound instance and gives it the name of the parameter.
	 * @param name. The String parameter is the new Sound instance's name.
	 */
	public Chord chord(int[] soundNums)
	{
		Sound[] _sArray = new Sound[soundNums.length];
		int _soundIndex = 0;
		int _arrayIndex = 0;
		while(_arrayIndex < soundNums.length)
		{
			if(soundNums[_arrayIndex] == _soundIndex)
			{
				_sArray[_arrayIndex] = _sounds[soundNums[_arrayIndex]];
				_soundIndex++;
				_arrayIndex++;
			}
			else
			{
				_soundIndex++;
			}
		}
		Chord numChord = new Chord(_sArray);
		return numChord;
	}
}
