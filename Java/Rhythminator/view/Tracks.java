package view;

import javax.swing.JPanel;

import controller.Controller;

public class Tracks extends JPanel
{

	private static final int SQUARE_SIZE = 30;
	private static final int GAP_SIZE = 10;

	private static final long serialVersionUID = 1L;
	private int _numTracks;
	private int _numBeats;
	private int[][] _noteSquares = new int[_numTracks][_numBeats];

	public Tracks(Controller controller, int numTracks, int numBeats)
	{
		super();
		this.setLayout(null);
		int x = 0, y = 0;
		_numTracks = numTracks;
		_numBeats = numBeats;
		for(int trackNum=0; trackNum<numTracks; trackNum++)
		{
			_numTracks = numTracks;
			for(int beatNum=0; beatNum<numBeats; beatNum++)
			{
				_numBeats = numBeats;
				NoteSquare note = new NoteSquare(controller, trackNum, beatNum);
				note.setSize(SQUARE_SIZE, SQUARE_SIZE);
				note.setLocation(x, y);
				this.add(note);
				x += SQUARE_SIZE + GAP_SIZE;
				int fu = note.getValue();
				_noteSquares[trackNum][beatNum] = fu;
				System.out.println(note.getValue());
				System.out.println("trackNum: " + trackNum + " beatNum: " + beatNum);
			}
			x = 0;
			y += View.TRACK_HEIGHT;
		}
		int width = numBeats * (SQUARE_SIZE + GAP_SIZE);
		int height = numTracks * (SQUARE_SIZE + GAP_SIZE);
		this.setSize(width, height);
	}

	public String getNoteSquare()
	{
		String x = " ";
		for(int index = 0; index < _numTracks; index++)
		{
			for(int index2 = 0; index2 < _numBeats; index2++)
			{
				System.out.println("index: " + index + "  index2: " + index2);
				int value = _noteSquares[index][index2];
				x = value + " ";
				System.out.println(x);
			}
			System.out.println();
		}
		return x;
	}
}
