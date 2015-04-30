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

public class SoundNameBox extends Box
{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 150;
	public static final int HEIGHT = 30;

	private Controller _controller;
	private int _track;

	public SoundNameBox(Controller controller, int track)
	{
		super();
		_controller = controller;
		_track = track;
		this.setSize(WIDTH, HEIGHT);
	}

	@Override
	public void mousePressed(MouseEvent mev)
	{
		String x = this.getText();
		SoundChooser.open(_controller, _track, x);

	}
}
