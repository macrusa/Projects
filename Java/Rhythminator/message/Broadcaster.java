package message;

/**
 * Broadcasts a message to multiple subscribers.
 */
public class Broadcaster implements IPublisher, ISubscriber
{
  
  private ISubscriber[] _subscribers;
  private int _nextSubscriber = 0;
  
  /**
   * Creates an instance of a Broadcaster that can hold up to some number of
   * subscribers.
   * @param numSubscribers The maximum number of subscribers that this
   * Broadcaster can hold.
   */
  public Broadcaster(int numSubscribers)
  {
    _subscribers = new ISubscriber[numSubscribers];
  }

  @Override
  public void notify(Message message)
  {
    for(ISubscriber subscriber : _subscribers)
      if(subscriber != null)
        subscriber.notify(message);
  }
  
  @Override
  public void subscribe(ISubscriber subscriber)
  {
    _subscribers[_nextSubscriber++] = subscriber;
  }

  @Override
  public void unsubscribe(ISubscriber subscriber)
  { 
  }

}
