package model;

import message.Sequencer;

public class Model
{

	public int _numTracks;
	public int _numBeats;
	private SoundBank _soundBank;
	private Sequencer _sequencer;
	private Chord[] _chords;
	private Clock _clock;

	/**
	 * The model sets up the clock.
	 * Most of the work of running the application happens in the clock.
	 * @param numTracks
	 * @param numBeats
	 */
	public Model(int numTracks, int numBeats)
	{
		_numTracks = numTracks;
		_numBeats = numBeats;
		_sequencer = new Sequencer(numTracks);
		Sound[] sounds = new Sound[Sound.getAllSoundFileNames().length];
		_soundBank = new SoundBank(sounds);
		_chords = new Chord[numBeats];
		for(int x = 0; x < numBeats; x++)
		{
			Chord c = new Chord(_soundBank, numTracks);
			_chords[x] = c;
			_sequencer.subscribe(_chords[x]);
		}
		_clock = new Clock();
		_clock.subscribe(_sequencer);
	}

	public int getBeatNumber()
	{
		return _sequencer.getStepNumber();
	}

	public Sequencer getSequencer()
	{
		return _sequencer;
	}

	public Clock getClock()
	{
		return _clock;
	}

	public void startPlaying()
	{
		_clock.start();
	}

	public void stopPlaying()
	{
		_clock.stop();
	}

	public void setNote(int trackNum, int beatNum, boolean value)
	{	
		_chords[beatNum].setNote(trackNum, value);
	}

	public void setSoundName(int trackNum, String soundName)
	{
		Sound sound = new Sound(soundName);
		_soundBank.setSound(trackNum, sound);
	}
	
	public int getTrackNumber()
	{
		return _numTracks;
	}
	
	public SoundBank getSoundBank()
	{
		return _soundBank;
	}
}
