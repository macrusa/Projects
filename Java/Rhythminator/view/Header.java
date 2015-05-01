package view;

import gui.Button;
import gui.TextBox;

import javax.swing.JPanel;

import controller.Controller;

public class Header extends JPanel
{

  private static final long serialVersionUID = 1L;

  private TextBox _fileNameBox;

  public Header(Controller controller)
  {
    super();
    this.setLayout(null);
    _fileNameBox = new TextBox("Unnamed", "Enter a new name:", "Change name");
    _fileNameBox.setSize(200, 30);
    _fileNameBox.setLocation(0, 0);
    this.add(_fileNameBox);
    
    Button loadButton = new Button(controller, "Load");
    loadButton.setSize(60, 30);
    loadButton.setLocation(_fileNameBox.getX() + _fileNameBox.getWidth() + 10, 0);
    this.add(loadButton);

    Button saveButton = new Button(controller, "Save");
    saveButton.setSize(60, 30);
    saveButton.setLocation(loadButton.getX() + loadButton.getWidth() + 10, 0);
    this.add(saveButton);

    Button quitButton = new Button(controller, "Quit");
    quitButton.setSize(60, 30);
    quitButton.setLocation(saveButton.getX() + saveButton.getWidth() + 40, 0);
    this.add(quitButton);
    this.setSize(quitButton.getX() + quitButton.getWidth(), 30);
  }

  public String getFileName()
  {
    return _fileNameBox.getText();
  }

}
