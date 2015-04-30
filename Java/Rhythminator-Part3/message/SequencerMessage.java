//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package message;

public class SequencerMessage extends Message
{

  private int _stepNumber;

  public SequencerMessage(IPublisher publisher, int stepNumber)
  {
    super(publisher);
    _stepNumber = stepNumber;
  }

  public int getStepNumber()
  {
    return _stepNumber;
  }

}
