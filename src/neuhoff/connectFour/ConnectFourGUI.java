package neuhoff.connectFour;

public class ConnectFourGUI {

	public static void main(String[] args) {
		int choice = 0;
		ConnectFour gui = new ConnectFour();
		gui.setVisible(true);
		while (choice != -1) {
			switch (choice) {
			case 0:
				if (gui.isWinner()) {
					choice = 1;
				} else if (gui.isDraw()) {
					choice = 2;
				} else if (gui.newGame()) {
					gui = new ConnectFour();
					gui.setVisible(true);
					choice = 0;
				}
				break;
			case 1:
				if (gui.showWin() == 0) {
					gui = new ConnectFour();
					gui.setVisible(true);
					choice = 0;
				} else {
					choice = -1;
				}
				break;
			case 2:
				if (gui.draw() == 0) {
					gui = new ConnectFour();
					gui.setVisible(true);
					choice = 0;
				} else {
					choice = -1;
				}
				break;
			}
		}
	}
}
