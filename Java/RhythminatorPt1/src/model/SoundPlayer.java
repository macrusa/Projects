//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package model;

import message.ISubscriber;
import message.Message;

/**
 * The class SoundPlayer is a subscriber. When it receives a notification,
 * it will play a sound.
 */
public class SoundPlayer implements ISubscriber
{

	/**
	 * Creates a new sound instance and gives it the name of the parameter.
	 * @param name. The String parameter is the new Sound instance's name.
	 */
	Sound _sound;
	public SoundPlayer(String name)
	{
		_sound = new Sound(name);
	}

	/**
	 * Stores the sound in the parameter to the member variable _sound.
	 * @param sound. A Sound parameter
	 */
	public SoundPlayer(Sound sound)
	{
		_sound = sound;
	}

	/**
	 * Plays the sound.
	 * @param msg. Message given to the subscribers.
	 */
	@Override
	public void notify(Message msg) 
	{
		_sound.play();
	}
}
