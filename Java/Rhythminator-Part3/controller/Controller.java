//Rhythminator-Part3
//CSE1102 09, Spring 2014
//Nancy Cheng
//5/2/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package controller;

import java.util.Scanner;

import gui.Button;
import gui.Dialog;
import gui.NumberSlider;
import message.ISubscriber;
import message.Message;
import model.Clock;
import model.Model;
import model.Sound;
import model.SoundBank;
import view.Header;
import view.NoteSquare;
import view.SoundNameBox;
import view.Tracks;
import view.View;

public class Controller implements ISubscriber
{
	private Model _model;
	private Clock _clock;
	private View  _view;
	private int x = 0;
	private String[] _soundNames = new String[x];

	public Controller(Clock clock, Model model)
	{
		_clock = clock;
		_model = model;
		_clock.subscribe(this);
	}

	public void buttonPressed(Button button)
	{
		if(button.getText().equals("Save"))
		{
			_buttonSave();
		}
		else if(button.getText().equals("Load"))
		{
			_buttonLoad();
		}
		else if(button.getText().equals("Play"))
		{
			_model.startPlaying();
			System.out.println("Controller.buttonPressed got Play button");
		}
		else if(button.getText().equals("Stop"))
		{
			_model.stopPlaying();
			//WHAT'S THE POINT OF CLEAR?
			_view.clearBeatNumbers();
			_model.getSequencer().reset();
			System.out.println("Controller.buttonPressed got Stop button");

		}
		else if(button.getText().equals("Quit"))
			_buttonQuit();
		else
		{
			System.out.println("Controller.buttonPressed " + button + " pressed");

		}
	}

	private void _buttonQuit()
	{
		if(Dialog.askYesNo("Exiting program", "Really quit?"))
			System.exit(0);
	}

	private void _buttonLoad()
	{
		/**
		System.out.println("Copy and paste the rhythm data");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int numberInput = sc.next();
		sc.next(numberinput);
		NumberSlider ns = _view.getNumberSlider();
		ns.setValue(numberInput);
		 **/
		System.out.println("Controller._buttonLoad called");
	}

	private void _buttonSave()
	{
		//Box name YES
		Header header = _view.getHeader();
		String headerName = header.getFileName();
		//System.out.println("Controller.buttonPressed Save:header " + headerName);
		System.out.println(headerName);

		//Track Sound Names
		//FIX
		//Row = 6

		//int _track = _view.getTrackNumber();
		//String[] strings = new String[_track - 1];
		//int x = 0;
		//strings[x] = soundName;
		//x++;
		
		//view.SoundBank sb = _view.getSoundBank();
		//String x = sb.getSoundName(track);
		//System.out.println(x);
		/**SoundBank sb = _model.getSoundBank();
		Sound[] sounds = sb.getSounds();
		Sound sound = sounds[_model.getTrackNumber()];
		String SoundName= sound.getName();
		System.out.println("Controller.buttonPressed Save:sound " + SoundName);
		 **/
		//Column = 16
		int beat = _view.getBeatNumber();
		Tracks tracks = _view.getTracks();
		String note = tracks.getNoteSquare();
		System.out.println(note);
		//System.out.println("Controller.buttonPressed Save:note ");


		//Tempo YES+
		NumberSlider ns = _view.getNumberSlider();
		int tempo = ns.getValue();
		System.out.println("Controller.buttonPressed Save:tempo " + tempo);

		//final String
		System.out.println("Controller._buttonSave called");
	}

	public void keyPressed(int keyCode)
	{
		System.out.println("Controller.keyPressed " + keyCode);
	}

	public void keyReleased(int keyCode)
	{
		System.out.println("Controller.keyReleased " + keyCode);
	}

	public void keyTyped(char keyChar)
	{
		System.out.println("Controller.keyTyped '" + keyChar + "'");
	}

	public void noteSquareClicked(NoteSquare noteSquare)
	{
		int trackNum = noteSquare.getTrackNumber();
		int beatNum = noteSquare.getBeatNumber();
		System.out.println("track = " + trackNum + ", beat = " + beatNum);
		boolean value;
		if(noteSquare.getValue() == 1)
		{
			value = true;
		}
		else
		{
			value = false;
		}

		_model.setNote(trackNum, beatNum, value);
		System.out.println("Controller.noteSquareClicked " + noteSquare);
	}

	@Override
	public void notify(Message message)
	{
		int x = _model.getBeatNumber() - 1;
		System.out.println(x);
		_view.setBeatNumber(x);
		System.out.println("Controller.notify " + message);
	}

	public void soundNameSelected(int trackNumber, String soundName)
	{
		_soundNames[x] = soundName;
		_model.setSoundName(trackNumber, soundName);
		_view.setSoundName(trackNumber, soundName);
		System.out.println("Controller.soundNameSelected for track " +  trackNumber + ": " + soundName);
	}

	public void setView(View view)
	{
		_view = view;
	}

	public void sliderChange(String name, int value)
	{
		long delay = 15000/value;
		_clock.setDelay(delay);
		System.out.println("Controller.sliderChange " + name + " = " + value);
	}

}
