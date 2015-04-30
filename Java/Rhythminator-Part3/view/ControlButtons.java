//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.Button;

import javax.swing.JPanel;

import controller.Controller;

public class ControlButtons extends JPanel
{

  private static final long serialVersionUID = 1L;

  public ControlButtons(Controller controller)
  {
    super();
    this.setLayout(null);
    Button playButton = new Button(controller, "Play");
    playButton.setSize(60, 30);
    playButton.setLocation(0, 0);
    Button stopButton = new Button(controller, "Stop");
    stopButton.setSize(60, 30);
    stopButton.setLocation(70, 0);
    this.add(playButton);
    this.add(stopButton);
    this.setSize(130, 30);
  }
}
