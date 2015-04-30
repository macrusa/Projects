//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

/**
 * Message class contains the publisher of the message.
 */
public class Message 
{
	/**
	 * Takes the parameter and stores it in a private IPublisher _publisher.
	 * @param publisher. IPublisher parameter.
	 */
	private IPublisher _publisher;
	public Message(IPublisher publisher)
	{
		_publisher = publisher;
	}
	/**
	 *getPublisher method that returns the publisher
	 */
	public IPublisher getPublisher()
	{
		return _publisher;
	}

}
