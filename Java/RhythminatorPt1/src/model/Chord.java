//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package model;

import message.Broadcaster;

/**
 * The class Chord accepts several Sound instances and creates one SoundPlayer 
 * for each sound and subscribe each to the Broadcaster.
 */
public class Chord extends Broadcaster
{
	/**
	 * For every sound in the parameter array, create a SoundPlayer instance
	 * and have the SoundPlayer subscribe to that instance.
	 * @param sounds. A sound array
	 */
	public Chord(Sound[] sounds)
	{
		super(sounds.length);
		for(int t = 0; t < sounds.length; t++)
		{
			SoundPlayer sp = new SoundPlayer(sounds[t]);
			this.subscribe(sp);
		}
	}

}
