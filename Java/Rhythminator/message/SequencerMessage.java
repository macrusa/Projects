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
