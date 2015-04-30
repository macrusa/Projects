//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

public interface ISubscriber
{
	/**
	 * All classes want the ISubscriber to implement the notify method
	 * so this will allow all publishers to notify the ISubscriber.
	/**
	 * Allows other publishers to notify the ISubscriber.
	 * @param msg. Message that must be supplied.
	 */
	public void notify(Message msg);
}
