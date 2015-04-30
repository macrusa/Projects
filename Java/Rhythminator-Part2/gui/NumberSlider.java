//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package gui;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

public class NumberSlider extends JPanel implements ChangeListener
{
	private String _name;
	private Controller _controller;
	private Box _box = new Box();
	private JSlider _jSlider;
	private static final long serialVersionUID = 1L;
	public NumberSlider(Controller controller, String name, int min, int max, int value)
	{
		setLayout(null);
		_name = name;
		_controller = controller;
		_box.setLocation(0, 0);
		_box.setSize(40, 30);
		_box.setText(Integer.toString(value));
		add(_box);
		_jSlider = new JSlider(JSlider.HORIZONTAL, min, max, value);
		_jSlider.setLocation(_box.getWidth(), 0);
		_jSlider.setSize(200, 30);
		this.setSize(_jSlider.getWidth() + _box.getWidth(), 30);
		add(_jSlider);
		_jSlider.addChangeListener(this);
		_jSlider.setFocusable(false);
	}
	@Override
	public void stateChanged(ChangeEvent e)
	{
		int sliderValue = _jSlider.getValue();
		_box.setText(Integer.toString(sliderValue));
		_controller.sliderChange(_name, sliderValue);
	}
}
