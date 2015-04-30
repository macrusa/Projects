//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

public interface IPublisher
{
  public void subscribe(ISubscriber subscriber);
  public void unsubscribe(ISubscriber subscriber);
}
