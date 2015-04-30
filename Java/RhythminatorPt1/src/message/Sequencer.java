//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

/**
 * Sequencer has multiple subscribers but only sends the message
 * to the next subscriber in the list. (Unlike the Broadcaster which 
 * sends the message to every subscriber.)
 */
public class Sequencer implements IPublisher, ISubscriber
{
	/**
	 * Creates an instance of a Sequencer that can hold up to some number of subscribers.
	 * @param maxSubscribers. The maximum number of subscribers that this Sequencer can hold.
	 */
	private ISubscriber[] _subscribers;
	public Sequencer(int maxSubscribers)
	{
		//ISubscriber instances array
		_subscribers = new ISubscriber[maxSubscribers];
	}

	/**
	 * Lets subscribers subscribe to the Sequencer.
	 */
	/**
	 * Takes a subscriber (subscriber) and places it into the next location (index++)
	 * in the subscriber array.
	 * @param subscriber. The subscriber that wants to subscribe to the Sequencer.
	 */
	int index = 0;
	@Override
	public void subscribe(ISubscriber subscriber)
	{
		_subscribers[index] = subscriber;
		//index = index + 1;
		index ++;
	}

	/**
	 * Lets subscribers unsubscribe from the Sequencer.
	 */
	/**
	 * Meant to take a subscriber (subscriber) and remove it from the subscriber array
	 * but Jeff said we won't use any unsubscribe methods.
	 * @param subscriber. The subscriber that wants to subscribe.
	 */
	@Override
	public void unsubscribe(ISubscriber subscriber)
	{	
	}


	/**
	 * Receives a notification (msg) and only sends to the next subscriber.
	 */
	/**
	 *Uses the if condition so that the first time the method is called, it uses the
	 *_tracker location of 0. The next time it is called, it uses the _tracker++ which is 
	 *array location 1. At the end of the array in which the _tracker = the length of the array,
	 *it goes back to subscriber number 0 again.
	 * @param msg. It's the message that you want to give to the next subscriber.
	 */
	int _tracker = 0;
	@Override
	public void notify(Message msg)
	{
		if (_tracker == _subscribers.length)
		{
			_tracker = 0;
			_subscribers[_tracker].notify(msg);
			_tracker++;
		}
		else if(_subscribers[_tracker] == null)
		{
			_tracker++;
		}
		else
		{
			_subscribers[_tracker].notify(msg);
			_tracker++;
		}
	}
}

