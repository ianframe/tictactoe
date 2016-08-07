import java.util.InputMismatchException;

public class GameTerminal
{
	private static String[][] _____________;
	private static boolean isXturn = _____________;
	private static int gridNumber = _____________;

	public static void main(String[] args)
	{

		_____________();
		_____________();
		while (_____________)
		{
			_____________ = getPlayerInput();
			drawSymbol(_____________);
			printBoard();
		}
		
		//What has occured in the game if you reach this line of code?
		System.out.pritln(_____________);
		
	}

	public static void setup()
	{
		//create the grid to record player moves
		gameBoard = new _____________;
		int gridNumber = _____________;
		for (_____________)
			for (_____________)
			{
				gameBoard[_____________][_____________] = _____________;
				_____________++;
			}
	}

	public static void printBoard()
	{
		//You may or may not want to add some print statements to space things out to the board easier to read

		for (_____________)
		{
			for (_____________)
			{
				if (gameBoard[r][c] == _____________) //space has not been played yet so it doesn't have a String here yet
				{
					_____________.print("_\t"); // \t is an escape character for a tab
				}
				else
					System.out.print(gameBoard[i][j] + "\t");
			}
			_____________();
		}
		
		//You may or may not want to add some print statements to space things out to the board easier to read
	}

	public static boolean hasWinner()
	{
		if (checkRows() == _____________)
			return _____________;
		else if (checkCols() == _____________)
			return true;
		else if (_____________())
			return true;
		else
			return _____________;
	}

	public static boolean checkRows()
	{
		//to be implemented by you. don't forget to check for null Strings first to avoid a runtime null point exception
	}

	public static boolean checkCols()
	{
		//to be implemented by you. don't forget to check for null Strings first to avoid a runtime null point exception
		//this method sure does seem AWFULLY similar to checkRows(). Hmmmm....

	}

	public static boolean checkDiags()
	{
		//to be implemented by you. don't forget to check for null Strings first to avoid a runtime null point exception
		//this method sure does seem AWFULLY similar to checkRows() and checkCols(). Hmmmm....
	}
	
	
	//this method returns an integer typed into the terminal by the user to indicate which square they would like to play
	public static int getPlayerInput()
	{
		//provide a message to the user about where they would like to play an X or O
		System.out.println(_____________);
		//i've handled the user input here for you. no need to add anything else for this method
		try{
			return StdIn.readInt();
		}
		catch (InputMismatchException e)
		{
			StdOut.println("Not a valid integer.");
			return -1;
		}
	}

	/* Grid layout is as follows:
	**	1 | 2 | 3
	**	4 | 5 | 6
	**	7 | 8 | 9
	*/
	public static void drawSymbol(int n)
	{
		String symbol;
		if (isXturn == _____________)
			symbol = _____________;
		else
			symbol = _____________;
		if (_____________)
		{
			StdOut.println("Come on, yo. That's not a valid number. Try again.");
			//change the marker for whose turn it is
			isXturn = !isXturn;
		}
		
		/*
		* Insert the necessary code to update the game board to either an X or an O depending on the passed parameter (the user's number)
		* This will take multiple lines of code
		*/

		//We've updated the game board, so it's time to change whose turn it is. 
		isXturn = _____________;
	}
}
