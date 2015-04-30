//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.NumberSlider;
import controller.Controller;

public class View
{

	public  static final int TRACK_HEIGHT = 40; // this must be public
	private static final int LEFT_MARGIN  = 20;
	private static final int TOP_MARGIN   = 20;

	private BeatNumbers _beatNumbers;
	private SoundBank _soundBank;
	private NumberSlider _tempoSlider;
	private Header _header;
	private Tracks _tracks;
	private int _trackNumber;
	private int _beatNumber;

	public View(Controller controller, int numTracks, int numBeats)
	{
		_beatNumber = numBeats;
		_trackNumber = numTracks;
		
		Window window = new Window(controller, "Rhythminator");

		_header = new Header(controller);
		_header.setLocation(LEFT_MARGIN, TOP_MARGIN);
		window.add(_header);

		_soundBank = new SoundBank(controller, numTracks);
		_soundBank.setLocation(LEFT_MARGIN, _header.getY() + _header.getHeight() + 20);
		window.add(_soundBank);

		_tracks = new Tracks(controller, numTracks, numBeats);
		_tracks.setLocation(LEFT_MARGIN + _soundBank.getWidth() + 20, _soundBank.getY());
		window.add(_tracks);

		// the model will need to be able to ask the View to show the active beat number,
		// so the BeatNumbers instance needs to be a member variable so we can have
		// access to it later
		_beatNumbers = new BeatNumbers(numBeats);
		_beatNumbers.setLocation(_tracks.getX(), _tracks.getY() + _tracks.getHeight());
		window.add(_beatNumbers);

		ControlButtons controlButtons = new ControlButtons(controller);
		controlButtons.setLocation(LEFT_MARGIN, _soundBank.getY() + _soundBank.getHeight());
		window.add(controlButtons);

		_tempoSlider = new NumberSlider(controller, "Tempo", 10, 200, 60);
		_tempoSlider.setLocation(_beatNumbers.getX(), _beatNumbers.getY() + _beatNumbers.getHeight() + 20);
		window.add(_tempoSlider);

		window.setVisible(true);
	}

	public void clearBeatNumbers()
	{
		_beatNumbers.clear();
	}

	public void setBeatNumber(int beatNumber)
	{
		_beatNumbers.setBeatNumber(beatNumber);
	}

	public void setSoundName(int trackNumber, String soundName)
	{
		_soundBank.setSoundName(trackNumber, soundName);
	}

	public NumberSlider getNumberSlider()
	{
		return _tempoSlider;
	}

	public Header getHeader()
	{
		return _header;
	}

	public Tracks getTracks()
	{
		return _tracks;
	}
	
	public int getBeatNumber()
	{
		return _beatNumber;
	}
	
	public int getTrackNumber()
	{
		return _trackNumber;
	}

	public SoundBank getSoundBank() 
	{
		return _soundBank;
		
	}
}