//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.Box;

import java.awt.event.MouseEvent;

import controller.Controller;

public class SoundNameBox extends Box
{

	public final static int WIDTH = 150;
	public final static int HEIGHT = 30;

	private Controller _controller;
	private int _trackNumber;

	private static final long serialVersionUID = 1L;

	public SoundNameBox(Controller controller, int trackNumber)
	{
		super();
		_controller = controller;
		_trackNumber = trackNumber;
		this.setSize(WIDTH, HEIGHT);
	}

	@Override
	public void mousePressed(MouseEvent mev)
	{
		String initialValue = this.getText();
		SoundChooser.open(_controller, _trackNumber, initialValue);
	}

}
