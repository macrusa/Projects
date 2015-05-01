package view;

import gui.Box;
import view.Colors;

public class BeatNumberSquare extends Box
{

	private int _beatNumber;
	private boolean _state = false;

	private static final long serialVersionUID = 1L;

	public BeatNumberSquare(int beatNumber)
	{
		super();
		_beatNumber = beatNumber;
		this.setText("" + _beatNumber);
		this.setForeground(Colors.BEATNUMBER_OFF_FG);
		this.setBackground(Colors.BEATNUMBER_OFF_BG);
	}

	public void setState(boolean state)
	{
		_state = state;
		if(_state)
		{
			this.setForeground(Colors.BEATNUMBER_ON_FG);
			this.setBackground(Colors.BEATNUMBER_ON_BG);
		}
		else
		{
			this.setForeground(Colors.BEATNUMBER_OFF_FG);
			this.setBackground(Colors.BEATNUMBER_OFF_BG);
		}
		this.invalidate();
	}

}
