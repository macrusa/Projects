//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.Box;

public class BeatNumberSquare extends Box
{
	private static final long serialVersionUID = 1L;
	public static int _beat;
	public static boolean _state;

	public BeatNumberSquare(int beat)
	{
		super();
		_beat = beat;
		_state = false;
		this.setText(Integer.toString(_beat));
		this.setForeground(Colors.BEATNUMBER_OFF_FG);
		this.setBackground(Colors.BEATNUMBER_OFF_BG);
		this.setSize(NoteSquare.SIZE, NoteSquare.SIZE);
	}

	public void setState(boolean state)
	{
		_state = state;
		if(_state == true)
		{
			this.setForeground(Colors.BEATNUMBER_ON_FG);
			this.setBackground(Colors.BEATNUMBER_ON_BG);
		}
		else if(_state == false)
		{
			this.setForeground(Colors.BEATNUMBER_OFF_BG);
			this.setBackground(Colors.BEATNUMBER_OFF_BG);
		}
		this.invalidate();
	}
}
