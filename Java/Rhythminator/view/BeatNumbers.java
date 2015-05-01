package view;

import javax.swing.JPanel;

public class BeatNumbers extends JPanel
{

  private BeatNumberSquare[] _beatNumberSquares;
  private int _lastBeatNumber = -1;

  private static final int SQUARE_SIZE = 30;
  private static final int GAP_SIZE = 10;

  private static final long serialVersionUID = 1L;

  public BeatNumbers(int numBeats)
  {
    super();
    this.setLayout(null);
    int x = 0;
    _beatNumberSquares = new BeatNumberSquare[numBeats];
    for(int beatNum=0; beatNum<numBeats; beatNum++)
    {
      BeatNumberSquare beat = new BeatNumberSquare(1 + beatNum);
      _beatNumberSquares[beatNum] = beat;
      beat.setSize(SQUARE_SIZE, SQUARE_SIZE);
      beat.setLocation(x, 0);
      this.add(beat);
      x += SQUARE_SIZE + GAP_SIZE;
    }
    int width = numBeats * (SQUARE_SIZE + GAP_SIZE);
    this.setSize(width, SQUARE_SIZE);
  }

  public void clear()
  {
    if(_lastBeatNumber > -1)
      _beatNumberSquares[_lastBeatNumber].setState(false);    
  }

  public void setBeatNumber(int beatNumber)
  {
    if(_lastBeatNumber > -1)
      _beatNumberSquares[_lastBeatNumber].setState(false);
    _beatNumberSquares[beatNumber].setState(true);
    _lastBeatNumber = beatNumber;
  }

}
