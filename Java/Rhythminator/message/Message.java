package message;

public class Message
{
  private IPublisher _publisher;
  
  public Message(IPublisher publisher)
  {
    _publisher = publisher;
  }

  public IPublisher getPublisher()
  {
    return _publisher;
  }
}
