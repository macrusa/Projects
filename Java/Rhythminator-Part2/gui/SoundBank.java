//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package gui;

import javax.swing.JPanel;

import view.NoteSquare;
import view.SoundNameBox;
import controller.Controller;

public class SoundBank extends JPanel
{
	private static final long serialVersionUID = 1L;
	private SoundNameBox[] _numTracks;
	public SoundBank(Controller controller, int tracks)
	{

		int x = 0;
		int y = 0;

		setLayout(null);
		_numTracks = new SoundNameBox[tracks];

		for(int index = 0; index < tracks; index++)
		{
			_numTracks[index] = new SoundNameBox(controller, tracks);
			_numTracks[index].setLocation(x, y);
			add(_numTracks[index]);
			y = y + SoundNameBox.HEIGHT + Tracks.GAP_SIZE;
		}
		this.setSize(SoundNameBox.WIDTH, ((SoundNameBox.HEIGHT * tracks) + (Tracks.GAP_SIZE * (tracks - 1))));
	}

	public void setSoundName(int track, String name)
	{
		_numTracks[track].setText(name);
	}

}
