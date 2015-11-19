package neuhoff.connectFour;

public class Logic {
	//private final int WINNER = 4;
	private int cellsLeft;
	private Board grid;

	public Logic(Board temp) {
		grid = temp;
		cellsLeft = grid.getCellsLeft();
	}

	public boolean playerMove(int x, int y, int player) {
		grid.setSquare(x, y, player);
		cellsLeft--;
		return check();
	}
	
	public boolean draw(){
		return cellsLeft == 0;
	}

	private boolean check() {
		int[][] board = grid.getBoard();
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {

				// check for 4 in a row horizontally
				if (col < 4) { //once row hits 4, can't possibly be 4 in a row
					if (board[row][col] != 0 
							&& board[row][col] == board[row][col + 1]
							&& board[row][col] == board[row][col + 2]
							&& board[row][col] == board[row][col + 3])
						return true;
				}
				
				// check 4 in a row vertically
				if (row < 3) { // can't be 4 in a row starting from the 3rd to last row
					if (board[row][col] != 0 
							&& board[row][col] == board[row + 1][col]
							&& board[row][col] == board[row + 2][col]
							&& board[row][col] == board[row + 3][col]) 
						return true;
				}

				// check negative delta
				if (col < 4 && row < 3) {
					if (board[row][col] != 0 
							&& board[row][col] == board[row + 1][col + 1]
							&& board[row][col] == board[row + 2][col + 2]
							&& board[row][col] == board[row + 3][col + 3]) 
						return true;
				}

				
				// check positive delta
				if (col > 2 && row < 3){
					if (board[row][col] != 0 
							&& board[row][col] == board[row + 1][col - 1]
							&& board[row][col] == board[row + 2][col - 2]
							&& board[row][col] == board[row + 3][col - 3]) 
					return true;
				}
			}
		}
		return false;
	}

}
