//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.Box;
import view.Colors;

import java.awt.event.MouseEvent;

import controller.Controller;

public class NoteSquare extends Box
{

	private Controller _controller;
	private int _trackNumber, _beatNumber;
	private int _value = 0;

	private static final long serialVersionUID = 1L;

	public NoteSquare(Controller controller, int trackNumber, int beatNumber)
	{
		super();
		_controller = controller;
		_trackNumber = trackNumber;
		_beatNumber = beatNumber;
		this.setBackground(Colors.NOTESQUARE_OFF);
	}

	public int getBeatNumber()
	{
		return _beatNumber;
	}

	public int getTrackNumber()
	{
		return _trackNumber;
	}

	public int getValue()
	{
		return _value;
	}

	public void setValue(int value)
	{
		System.out.println("NoteSquare.setValue " + value);
		_value = value;
		if(_value != 0)
			this.setBackground(Colors.NOTESQUARE_ON);
		else
			this.setBackground(Colors.NOTESQUARE_OFF);
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent mev)
	{
		this.setValue(1 - _value);
		_controller.noteSquareClicked(this);
		//tests if on 
		System.out.println(_value);
	}

	@Override
	public String toString()
	{
		return "NoteSquare(track=" + _trackNumber + ",beat=" + _beatNumber + ")";
	}

}
