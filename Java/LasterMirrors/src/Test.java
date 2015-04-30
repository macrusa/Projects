
public class Test
{
	static char[][] squares;
	static String[] initStrings =
		{
		"...../...\\",
		"..\\.......",
		"......./..",
		"..........",
		"........\\.",
		"..........",
		"..........",
		".....\\../.",
		"..\\....../",
		".........."
		};
	public static void main(String[] args)
	{
		squares = new char[initStrings.length][initStrings[1].length()];
		System.out.println(initStrings[1].toCharArray());
		System.out.println(initStrings[1].length());
		System.out.println(initStrings);
	}
}
