//Rhythminator Pt1
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/24/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

/**
 * IPublisher class allows subscribers to subscribe or unsubscribe.
 */
public interface IPublisher
{
	/**
	 * Lets subscribers subscribe to the broadcaster.
	 */
	/**
	 * Takes a subscriber (subscriber) and places it into the next location (index++)
	 * in the subscriber array.
	 * @param subscriber. The subscriber that wants to subscribe to the Broadcaster.
	 */
	public void subscribe(ISubscriber subscriber);
	/**
	 * Lets subscribers unsubscribe from the Broadcaster.
	 */
	/**
	 * Meant to take a subscriber (subscriber) and remove it from the subscriber array
	 * but Jeff said we won't use any unsubscribe methods.
	 * @param subscriber. The subscriber that wants to subscribe.
	 */
	public void unsubscribe(ISubscriber subscriber);

}
