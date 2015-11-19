package neuhoff.connectFour;

public class InternalBoard {
	int[][] board ;
	int cellsLeft;
	
	public InternalBoard(){
		board = new int[6][7];
		cellsLeft = 0;
		
		for (int x = 0; x < 6; x++){
			for (int y = 0; y < 7; y++){
				board[x][y] = 0;
				cellsLeft++;
			}
		}
	}
	
	public int getCellsLeft(){
		return cellsLeft;
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public boolean checkSquare(int a, int b, int c){
		return board[a][b] == c;
	}
	
	public void setSquare(int x, int y, int player){
		if (checkSquare(x,y,0))
			board[x][y] = player;
	}
	
	public int findNextX(int y){
		for (int x = 5; x >= 0; x--){
			if (board[x][y] == 0){
				return x;
			}
		}
		return -1;
	}
	
}
