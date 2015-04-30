//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier
package gui;

import java.awt.event.MouseEvent;

import controller.Controller;

public class Button extends Box
{
	private static final long serialVersionUID = 1L;
	private Controller _controller;

	public Button(Controller controller, String text)
	{
		super(text);
		_controller = controller;		
	}

	@Override
	public String toString()
	{
		return "Button(" + getText() + ")";
	}

	@Override
	public void mousePressed(MouseEvent mev)
	{
		_controller.buttonPressed(this);
	}
}
