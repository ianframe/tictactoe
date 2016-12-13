public class TicTacToeRunner
{
	private static final int WINDOW_SIZE = 600;
	private static final int LINE_BUFFER = 25;
	private static final int TILE_SIZE = WINDOW_SIZE / 3;
	private static boolean isXsTurn = true;
	private static String[][] board;

	public static void main(String[] args)
	{
		drawBoard();
		while (!isGameOver())
		{
			if (mouseClicked())
			{
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				int square = determineSquare(x, y);

				if(isXsTurn)
					drawShape("X", square);
				else
					drawShape("O", square);
				isXsTurn = !isXsTurn;
			}
		}
		System.out.println("We have a winner!");
	}

	public static void drawBoard()
	{
		StdDraw.setCanvasSize(WINDOW_SIZE, WINDOW_SIZE);
		StdDraw.setScale(0, WINDOW_SIZE);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(WINDOW_SIZE / 3, LINE_BUFFER, WINDOW_SIZE / 3, WINDOW_SIZE - LINE_BUFFER);
		StdDraw.line(2*WINDOW_SIZE / 3, LINE_BUFFER, 2*WINDOW_SIZE / 3, WINDOW_SIZE - LINE_BUFFER);		
		StdDraw.line(LINE_BUFFER, WINDOW_SIZE / 3, WINDOW_SIZE - LINE_BUFFER, WINDOW_SIZE / 3);
		StdDraw.line(LINE_BUFFER, 2*WINDOW_SIZE / 3, WINDOW_SIZE - LINE_BUFFER, 2*WINDOW_SIZE / 3);
		StdDraw.show();
		board = new String[3][3];
	}

	public static int determineSquare(double x, double y)
	{
		if (y > 2*WINDOW_SIZE / 3)
		{
			if (x < WINDOW_SIZE / 3)
				return 1;
			else if (x < 2*WINDOW_SIZE / 3)
				return 2;
			else
				return 3;
		}
		else if (y > WINDOW_SIZE / 3)
		{
			if (x < WINDOW_SIZE / 3)
				return 4;
			else if (x < 2*WINDOW_SIZE / 3)
				return 5;
			else 
				return 6;
		}
		else
		{
			if (x < WINDOW_SIZE / 3)
				return 7;
			else if (x < 2*WINDOW_SIZE / 3)
				return 8;
			else
				return 9;
		}
	}

	public static void drawShape(String letter, int square)
	{
		double x, y;
		if (square == 1 || square == 4 || square == 7)
			x = WINDOW_SIZE / 2 - TILE_SIZE;
		else if (square == 2 || square == 5 || square == 8)
			x = WINDOW_SIZE / 2;
		else
			x = WINDOW_SIZE / 2 + TILE_SIZE;
		if (square <= 3)
			y = WINDOW_SIZE - TILE_SIZE / 2;
		else if (square <= 6)
			y = WINDOW_SIZE / 2;
		else
			y = TILE_SIZE / 2;

		if (letter.equalsIgnoreCase("X"))
		{
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(x - TILE_SIZE / 2 + LINE_BUFFER, y - TILE_SIZE / 2 + LINE_BUFFER, x + TILE_SIZE / 2 - LINE_BUFFER, y + TILE_SIZE / 2 - LINE_BUFFER);
			StdDraw.line(x - TILE_SIZE / 2 + LINE_BUFFER, y + TILE_SIZE / 2 - LINE_BUFFER, x + TILE_SIZE / 2 - LINE_BUFFER, y - TILE_SIZE / 2 + LINE_BUFFER);
			addSymbolToBoard("X", square);
		}
		else
		{
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(x, y, TILE_SIZE / 2 - LINE_BUFFER);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(x, y, TILE_SIZE / 2 - 1.2*LINE_BUFFER);
			addSymbolToBoard("O", square);
		}
		StdDraw.show();
	}

	public static void addSymbolToBoard(String letter, int square)
	{
		if (square == 1)
			board[0][0] = letter;
		else if (square == 2)
			board[0][1] = letter;
		else if (square == 3)
			board[0][2] = letter;
		else if (square == 4)
			board[1][0] = letter;
		else if (square == 5)
			board[1][1] = letter;
		else if (square == 6)
			board[1][2] = letter;
		else if (square == 7)
			board[2][0] = letter;
		else if (square == 8)
			board[2][1] = letter;
		else
			board[2][2] = letter;
	}

	public static boolean isGameOver()
	{
		return (hasDiagonalsWon() || hasRowsWon() || hasColsWon());
	}

	public static boolean hasDiagonalsWon()
	{
		if (board[0][0] == null || board[1][1] == null || board[2][2] == null)
		{}
		else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
			return true;
		if (board[2][0] == null || board[1][1] == null || board[0][2] == null)
		{}
		else if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]))
			return true;
		
		return false;
	}

	public static boolean hasRowsWon()
	{
		if (board[0][0] == null || board[0][1] == null || board[0][2] == null)
		{}
		else if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]))
			return true;
		if (board[1][0] == null || board[1][1] == null || board[1][2] == null)
		{}
		else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]))
			return true;
		if (board[2][0] == null || board[2][1] == null || board[2][2] == null)
		{}
		else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]))
			return true;
		return false;
	}

	public static boolean hasColsWon()
	{
		if (board[0][0] == null || board[1][0] == null || board[2][0] == null)
		{}
		else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]))
			return true;
		if (board[0][1] == null || board[1][1] == null || board[2][1] == null)
		{}
		else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]))
			return true;
		if (board[0][2] == null || board[1][2] == null || board[2][2] == null)
		{}
		else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]))
			return true;
		return false;
	}

	public static void waitForStart()
	{
		while (!mouseClicked())
		{}
	}

	public static boolean mouseClicked()
	{
		if (StdDraw.mousePressed())
		{
			while (StdDraw.mousePressed())
			{}
			return true;
		}
		return false;
	}
}