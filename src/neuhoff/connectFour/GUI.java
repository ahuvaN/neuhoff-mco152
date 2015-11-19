package neuhoff.connectFour;

public class GUI {

	public static void main (String[] args){
		int choice = 0;
		Frame gui = new Frame();
		gui.setVisible(true);
		while(choice != -1){
			switch(choice){
			case 0:
				if (gui.isWinner()){
					choice = 1;
				}
				else if (gui.isDraw()){
					choice = 2;
				}
				else if (gui.newGame()){
					gui = new Frame();
					gui.setVisible(true);
					choice = 0;
				}
				break;
			case 1:
				if(gui.showWin() == 0) {
					gui = new Frame();
					gui.setVisible(true);
					choice = 0;
				}
				else{
					choice = -1;
				}
				break;
			case 2:
				if (gui.draw() == 0){
					gui = new Frame();
					gui.setVisible(true);
					choice = 0;
				}
				else {
					choice = -1;
				}
				break;
			}
		}
	}
}
