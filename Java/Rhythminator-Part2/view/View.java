//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package view;

import gui.BeatNumbers;
import gui.Box;
import gui.Button;
import gui.ControlButtons;
import gui.Header;
import gui.NumberSlider;
import gui.SoundBank;
import gui.Tracks;
import controller.Controller;

public class View
{

	public  static final int TRACK_HEIGHT = 40; // this one must be public
	private static final int LEFT_MARGIN  = 20;
	private static final int TOP_MARGIN   = 20;

	public View(Controller controller, int numTracks, int numBeats)
	{
		Window window = new Window(controller, "Rhythminator");
		window.setSize(900, 500);
		//my statements here

		Header header = new Header(controller);
		header.setLocation(LEFT_MARGIN, TOP_MARGIN);
		window.add(header);

		SoundBank sb = new SoundBank(controller, numTracks);
		sb.setLocation(LEFT_MARGIN, header.getHeight() + TOP_MARGIN + 20);
		window.add(sb);

		Tracks tracks = new Tracks(controller, numTracks, numBeats);
		tracks.setLocation(LEFT_MARGIN + sb.getWidth() + 20, header.getHeight() + TOP_MARGIN + 20);
		window.add(tracks);

		ControlButtons cb = new ControlButtons(controller);
		cb.setLocation(LEFT_MARGIN, sb.getHeight() + 80);
		window.add(cb);

		BeatNumbers bn = new BeatNumbers(numBeats);
		bn.setLocation(LEFT_MARGIN + sb.getWidth() + 20, tracks.getHeight() + 80);
		window.add(bn);

		NumberSlider ns = new NumberSlider(controller, "number", 0, 200, 60);
		ns.setLocation(LEFT_MARGIN + sb.getWidth() + 20, tracks.getHeight() + header.getHeight() + bn.getHeight() + TOP_MARGIN + 50);
		window.add(ns);
		//my statements end here

		//previous test statements
		/**
		Box box = new Box();
		box.setSize(200, 100);
		box.setLocation(LEFT_MARGIN, TOP_MARGIN);
		window.add(box);
		 **/

		/**Button button1 = new Button(controller, "Push me!");
    	button1.setSize(100, 40);
    	button1.setLocation(400, 100);
    	window.add(button1);
		 **/

		/** NumberSlider ns = new NumberSlider(controller, "number", 0, 10, 5);
    	ns.setLocation(400, 200);
    	window.add(ns);
		 **/

		// NoteSquare noteSquare = new NoteSquare(controller, /*track*/1, /*beat*/2);
		// noteSquare.setLocation(100, 100);
		//window.add(noteSquare);

		/**BeatNumberSquare numberSquare = new BeatNumberSquare(1);
		BeatNumberSquare numberSquare2 = new BeatNumberSquare(2);
		numberSquare2.setState(true);
		numberSquare.setLocation(LEFT_MARGIN, 0);
		window.add(numberSquare);
		numberSquare2.setLocation(LEFT_MARGIN, 100);
		window.add(numberSquare2);
		 **/

		/**SoundNameBox soundBox = new SoundNameBox(controller, numTracks);
		soundBox.setLocation(LEFT_MARGIN, 0);
		window.add(soundBox);
		 **/

		/**ControlButtons buttons = new ControlButtons(controller);
		buttons.setLocation(LEFT_MARGIN, TOP_MARGIN);
		window.add(buttons);
		 **/

		/**Tracks tracks = new Tracks(controller, 3, 4);
		window.add(tracks);
		 **/

		/**Header header = new Header(controller);
		header.setLocation(LEFT_MARGIN, TOP_MARGIN);
		window.add(header);
		 **/

		/**BeatNumbers bn = new BeatNumbers(8);
		bn.setLocation(10, 10);
		window.add(bn);
		bn.setBeatNumber(3);
		bn.setBeatNumber(4);
		 **/

		window.setVisible(true); 
	}
}
