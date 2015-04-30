//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package controller;
import javax.swing.JSlider;
import view.NoteSquare;
import gui.Button;

public class Controller
{
	public Controller()
	{
	}

	public void buttonPressed(Button button) 
	{
		button.toString();
		System.out.println("The button has been pressed");
	}

	public void keyPressed(int keyCode)
	{
		//System.out.println("Controller.keyPressed " + keyCode);
	}

	public void keyReleased(int keyCode)
	{
		//System.out.println("Controller.keyReleased " + keyCode);
	}

	public void keyTyped(char keyChar)
	{
		//System.out.println("Controller.keyTyped '" + keyChar + "'");
	}

	public void sliderChange(String slider, int x) 
	{
		System.out.println("Slider " + slider + " changed to " + x);	
	}

	public void soundNameSelected(int trackNumber, String soundName)
	{
		System.out.println("Sound " + soundName + " selected for track " + trackNumber);
	}

	public void noteSquareClicked(NoteSquare noteSquare)
	{
		System.out.println("The NoteSquare instance was clicked " + noteSquare.toString());
	}
}
