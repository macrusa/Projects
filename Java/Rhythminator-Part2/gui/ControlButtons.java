//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package gui;

import javax.swing.JPanel;

import controller.Controller;

public class ControlButtons extends JPanel
{
	private static final long serialVersionUID = 1L;

	public ControlButtons(Controller controller)
	{
		setLayout(null);
		Button playButton = new Button(controller, "Play");
		Button stopButton = new Button(controller, "Stop");
		this.add(playButton);
		this.add(stopButton);
		playButton.setSize(60, 30);
		stopButton.setSize(60, 30);
		playButton.setLocation(0,0);
		stopButton.setLocation(70,0);
		this.setSize(130, 30);
	}
}
