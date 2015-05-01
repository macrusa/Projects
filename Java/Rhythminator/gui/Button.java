package gui;

import java.awt.event.MouseEvent;

import controller.Controller;

public class Button extends Box
{

  private Controller _controller;

  private static final long serialVersionUID = 1L;

  public Button(Controller controller, String text)
  {
    super();
    _controller = controller;
    this.setText(text);
    this.setForeground(Colors.BUTTON_FG);
    this.setBackground(Colors.BUTTON_BG);
  }

  @Override
  public void mousePressed(MouseEvent mev)
  {
    _controller.buttonPressed(this);
  }

  @Override
  public String toString()
  {
    return "Button(" + getText() + ")";
  }

}
