package view;

import javax.swing.JComponent;

import controller.Controller;

public class SoundBank extends JComponent
{

	private SoundNameBox[] _soundNames;

	private static final long serialVersionUID = 1L;

	public SoundBank(Controller controller, int numTracks)
	{
		super();
		_soundNames = new SoundNameBox[numTracks];
		for(int trackNum=0; trackNum<numTracks; trackNum++)
		{
			SoundNameBox snb = new SoundNameBox(controller, trackNum);
			snb.setSize(150, 30);
			snb.setLocation(0, trackNum * View.TRACK_HEIGHT);
			this.add(snb);
			_soundNames[trackNum] = snb;
		}
		this.setSize(150, numTracks*View.TRACK_HEIGHT);
	}

	public void setSoundName(int trackNumber, String soundName)
	{
		_soundNames[trackNumber].setText(soundName);
	}
	
	public String getSoundName(int trackNumber)
	{
		return _soundNames[trackNumber].getText();
	}

}
