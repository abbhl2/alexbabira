package AIModule;

public class Game {

	// stores the thread id and the player number

	private int[][] GameBoard;
	private String winPositions;
	protected  final int width = 7;
	protected  final int height = 6;

	public Game() {
		super();
		GameBoard = new int[width][height];

		// Initialize the gameboard
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				GameBoard[col][row] = -1;
			}
		}

	}


	/**
	 * States if there occured a draw after each move by either player
	 * 
	 * @return
	 */
	public boolean Draw() {
		int spotsfilled = 0;
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				if (GameBoard[col][row] == 1 || GameBoard[col][row] == 2) {
					spotsfilled++;
				}
			}
		}
		if (spotsfilled == height * width) {
			return true;
		}
		return false;
	}

	public int makeMove(int plnb, int col) {
		int currentrow = -1;

		for (int i = 0; i < height; i++) {
			if (GameBoard[col][i] == -1) {
				GameBoard[col][i] = plnb;
				currentrow = i;
				break;
			}
		}

		return currentrow;
	}

	/***
	 * Code adapted form the link below Ref:
	 * http://wiki.acse.net/images/1/1d/ConnectFour.pdf
	 * 
	 * @return
	 */
	public int hasWon() {
		int player = -1;

		// check for a horizontal win
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width-3; column++) {
				if (GameBoard[column][row] != -1
						&& GameBoard[column][row] == GameBoard[column + 1][row]
						&& GameBoard[column][row] == GameBoard[column + 2][row]
						&& GameBoard[column][row] == GameBoard[column + 3][row]) {

					winPositions = column + "\t" + row + "\t" + (column + 1)
							+ "\t" + row + "\t" + (column + 2) + "\t" + row
							+ "\t" + (column + 3) + "\t" + row;
					player = GameBoard[column][row];
				}
			}
		}

		// check for a vertical win
		for (int row = 0; row < height-3; row++) {
			for (int column = 0; column < width; column++) {
				if (GameBoard[column][row] != -1
						&& GameBoard[column][row] == GameBoard[column][row + 1]
						&& GameBoard[column][row] == GameBoard[column][row + 2]
						&& GameBoard[column][row] == GameBoard[column][row + 3]) {

					winPositions = column + "\t" + row + "\t" + column + "\t"
							+ (row + 1) + "\t" + column + "\t" + (row + 2)
							+ "\t" + column + "\t" + (row + 3);
					player = GameBoard[column][row];
				}
			}
		}

		// check for a diagonal win (positive slope)
		for (int row = 0; row < height-3; row++) {
			for (int column = 0; column < width-3; column++) {
				if (GameBoard[column][row] != -1
						&& GameBoard[column][row] == GameBoard[column + 1][row + 1]
						&& GameBoard[column][row] == GameBoard[column + 2][row + 2]
						&& GameBoard[column][row] == GameBoard[column + 3][row + 3]) {

					winPositions = column + "\t" + row + "\t" + (column + 1)
							+ "\t" + (row + 1) + "\t" + (column + 2) + "\t"
							+ (row + 2) + "\t" + (column + 3) + "\t"
							+ (row + 3);
					player = GameBoard[column][row];
				}
			}
		}

		// check for a diagonal win (negative slope)
		for (int row = height-3; row < height; row++) {
			for (int column = 0; column < width-3; column++) {
				if (GameBoard[column][row] != -1
						&& GameBoard[column][row] == GameBoard[column + 1][row - 1]
						&& GameBoard[column][row] == GameBoard[column + 2][row - 2]
						&& GameBoard[column][row] == GameBoard[column + 3][row - 3]) {

					winPositions = column + "\t" + row + "\t" + (column + 1)
							+ "\t" + (row - 1) + "\t" + (column + 2) + "\t"
							+ (row - 2) + "\t" + (column + 3) + "\t"
							+ (row - 3);
					player = GameBoard[column][row];
				}
			}
		}

		return player;
	}

	public boolean canMove(int x) {
		return GameBoard[x][5] == -1;
	}

	public void undo(int x, int player) {
		int y = 5;
		while (y >= 0 && GameBoard[x][y] == -1)
			--y;
		if (GameBoard[x][y] == player)
			GameBoard[x][y] = -1;
	}

	public int getScore() {
		return calculateWinningLines(2) - calculateWinningLines(1);
	}

	public String getWinPositions() {
		return winPositions;
	}

	public void setWinPositions(String winPositions) {
		this.winPositions = winPositions;
	}

	public int[][] getGameBoard() {
		return GameBoard;
	}

	public void setGameBoard(int[][] gameBoard) {
		GameBoard = gameBoard;
	}

	private int other(int player) {
		if (player == 1)
			return 2;
		else
			return 1;
	}

	public int calculateWinningLines(int player) {
		int score = 0;

		// check for a horizontal win
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width-3; column++) {
				if ((GameBoard[column][row] != other(player)
						&& GameBoard[column + 1][row] != other(player)
						&& GameBoard[column + 2][row] != other(player) && GameBoard[column + 3][row] != other(player))
						&& (GameBoard[column][row] == player
								|| GameBoard[column + 1][row] == player
								|| GameBoard[column + 2][row] == player || GameBoard[column + 3][row] == player)) {
					score++;
				}
			}
		}

		// check for a vertical win
		for (int row = 0; row < height-3; row++) {
			for (int column = 0; column < width; column++) {
				if ((GameBoard[column][row] != other(player)
						&& GameBoard[column][row + 1] != other(player)
						&& GameBoard[column][row + 2] != other(player) && GameBoard[column][row + 3] != other(player))
						&& (GameBoard[column][row] == player
								|| GameBoard[column][row + 1] == player
								|| GameBoard[column][row + 2] == player || GameBoard[column][row + 3] == player)) {

					score++;

				}
			}
		}

		// check for a diagonal win (positive slope)
		for (int row = 0; row < height-3; row++) {
			for (int column = 0; column < width-3; column++) {
				if ((GameBoard[column][row] != other(player)
						&& GameBoard[column + 1][row + 1] != other(player)
						&& GameBoard[column + 2][row + 2] != other(player) && GameBoard[column + 3][row + 3] != other(player))
						&& (GameBoard[column][row] == player
								|| GameBoard[column + 1][row + 1] == player
								|| GameBoard[column + 2][row + 2] == player || GameBoard[column + 3][row + 3] == player)) {

					score++;
				}
			}
		}

		// check for a diagonal win (negative slope)
		for (int row = height-3; row < height; row++) {
			for (int column = 0; column < width-3; column++) {
				if ((GameBoard[column][row] != other(player)
						&& GameBoard[column + 1][row - 1] != other(player)
						&& GameBoard[column + 2][row - 2] != other(player) && GameBoard[column + 3][row - 3] != other(player))
						&& (GameBoard[column][row] == player
								|| GameBoard[column + 1][row - 1] == player
								|| GameBoard[column + 2][row - 2] == player || GameBoard[column + 3][row - 3] == player)) {

					score++;
				}
			}
		}

		return score;
	}
}
