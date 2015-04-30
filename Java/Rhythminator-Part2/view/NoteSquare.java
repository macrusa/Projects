//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import java.awt.event.MouseEvent;

import controller.Controller;
import gui.Box;
import view.Colors;

//Extends gives NoteSquare all the features of a Box (Box is parent class)
public class NoteSquare extends Box
{
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 30;

	private Controller _controller;
	private int _track;
	private int _beat;
	private int _control;

	public NoteSquare(Controller controller, int track, int beat)
	{
		//Invokes Box (parent class)'s constructor
		super();
		_controller = controller;
		_track = track;
		_beat = beat;
		_control = 0;
		this.setSize(SIZE, SIZE);
		this.setBackground(Colors.NOTESQUARE_OFF);
	}

	public int getBeat()
	{
		return _beat;
	}

	public int getTrack()
	{
		return _track;
	}

	public int getValue()
	{
		return _control;
	}
	public void setValue(int value)
	{
		_control = value;
		if(value == 0)
		{
			this.setBackground(Colors.NOTESQUARE_OFF);
		}
		else
		{
			this.setBackground(Colors.NOTESQUARE_ON);
		}
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent mev)
	{
		if(_control == 0)
		{
			this.setValue(1);
		}
		else if(_control == 1)
		{
			this.setValue(0);
		}
		_controller.noteSquareClicked(this);

	}

	@Override
	public String toString()
	{
		return ("NoteSquare(track = " + _track + ", beat = " + _beat + " )");
	}
}
