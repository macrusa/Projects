//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

/**
 * Broadcasts the message it receives to the subscribers one after the other.
 */
public class Broadcaster implements IPublisher, ISubscriber
{
	/**
	 * Creates an instance of a Broadcaster that can hold up to some number of subscribers.
	 * @param maxSubscribers. The maximum number of subscribers that this Broadcaster can hold.
	 */
	private ISubscriber[] _subscribers;
	public Broadcaster(int maxSubscribers)
	{
		//ISubscriber instances array
		_subscribers = new ISubscriber[maxSubscribers];
	}

	/**
	 * Lets subscribers subscribe to the broadcaster.
	 */
	/**
	 * Takes a subscriber (subscriber) and places it into the next location (index++)
	 * in the subscriber array.
	 * @param subscriber. The ISubscriber that wants to subscribe to the Broadcaster.
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
	 * Lets subscribers unsubscribe from the Broadcaster.
	 */
	/**
	 * Meant to take a subscriber (subscriber) and remove it from the subscriber array
	 * but Jeff said we won't use any unsubscribe methods.
	 * @param subscriber. The ISubscriber that wants to unsubscribe.
	 */
	@Override
	public void unsubscribe(ISubscriber subscriber)
	{	
	}


	/**
	 * Receives a notification (msg) and notifies all the subscribers.
	 */
	/**
	 *Goes over or iterates over all the elements in the _subscribers array (for loop)
	 *and the if condition is if the element is not equal to null, call the notify method
	 *on that subscriber.
	 * @param msg. It's the message that you want to give to the subscribers.
	 */
	@Override
	public void notify(Message msg)
	{
		//for (start, end, interval)
		for(int t=0; t<_subscribers.length; t++)
		{
			if (_subscribers[t] != null)
			{
				_subscribers[t].notify(msg);
			}
		}
	}
}
