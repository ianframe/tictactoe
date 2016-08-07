import java.util.InputMismatchException;

public class GameTerminal
{
	private static String[][] gameBoard;
	private static boolean isXturn = !true;
	private static int numOfTurns = 0;

	public static void main(String[] args)
	{

		setup();
		printBoard();
		while (!hasWinner() && numOfTurns <= 9)
		{
			int n = getPlayerInput();
			drawSymbol(n);
			printBoard();
		}
		if (numOfTurns < 9)
			StdOut.println("We have a winner!");
		else
			StdOut.println("It's a tie!");
	}

	public static void setup()
	{
		//create the grid to record player moves
		gameBoard = new String[3][3];
		int gridNumber = 1;
		for (int r = 0; r < gameBoard.length; r++)
			for (int c = 0; c < gameBoard[0].length; c++)
			{
				gameBoard[r][c] = gridNumber + "";
				gridNumber++;
			}
	}

	public static void printBoard()
	{
		StdOut.println();

		for (int i = 0; i < gameBoard.length; i++)
		{
			for (int j = 0; j < gameBoard[i].length; j++)
			{
				if (gameBoard[i][j] == null) //space has not been played yet
				{
					StdOut.print("_\t");
				}
				else
					StdOut.print(gameBoard[i][j] + "\t");
			}
			StdOut.println();
		}
		StdOut.println();
	}

	public static boolean hasWinner()
	{
		if (checkRows())
			return true;
		else if (checkCols())
			return true;
		else if (checkDiags())
			return true;
		return false;
	}

	public static boolean checkRows()
	{
		for (String[] row : gameBoard)
		{
			if (row[0] == null || row[1] == null || row[2] == null)
			{}
			else if (row[0].equals(row[1]) && row[1].equals(row[2]))
				return true;
		}
		return false;
	}

	public static boolean checkCols()
	{
		for (int c = 0; c < gameBoard.length; c++)
		{
			if (gameBoard[0][c] == null || gameBoard[1][c] == null || gameBoard[2][c] == null)
			{}
			else if (gameBoard[0][c].equals(gameBoard[1][c]) && gameBoard[1][c].equals(gameBoard[2][c]))
				return true;
		}		
		return false;
	}

	public static boolean checkDiags()
	{
		//check top left to bottom right
		if (gameBoard[0][0] == null || gameBoard[1][1] == null || gameBoard[2][2] == null)
		{}
		else if(gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]))
			return true;
		//check top right to bottom left
		if (gameBoard[0][2] == null || gameBoard[1][1] == null || gameBoard[2][0] == null)
		{}
		else if(gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]))
			return true;
		//no diagonal matches, so no winner yet
		return false;
	}

	public static int getPlayerInput()
	{
		StdOut.print("Where would you like to go? ");
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
	**	1 |	2 | 3
	**	4 |	5 | 6
	**	7 | 8 | 9
	*/
	public static void drawSymbol(int n)
	{
		String symbol;
		if (isXturn)
			symbol = "X";
		else
			symbol = "O";
		if (n < 1 || n > 9)
		{
			StdOut.println("Come on, yo. That's not a valid number. Try again.");
			isXturn = ! isXturn;
		}
		else if (n == 1)
			gameBoard[0][0] = symbol;
		else if (n == 2)
			gameBoard[0][1] = symbol;
		else if (n ==3 )
			gameBoard[0][2] = symbol;
		else if (n == 4)
			gameBoard[1][0] = symbol;
		else if (n == 5)
			gameBoard[1][1] = symbol;
		else if (n == 6)
			gameBoard[1][2] = symbol;
		else if (n == 7)
			gameBoard[2][0] = symbol;
		else if (n == 8)
			gameBoard[2][1] = symbol;
		else if (n == 9)
			gameBoard[2][2] = symbol;

		isXturn = !isXturn;
		numOfTurns += 1;
	}

}