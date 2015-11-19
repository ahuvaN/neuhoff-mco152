package neuhoff.connectFour;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VisibleBoard extends JPanel {

	private JButton[] grid;
	private int player;
	private boolean isWinner, isDraw, exit, newGame;
	private InternalBoard board;
	private InternalLogic logic;
	private ImageIcon icon;

	public VisibleBoard() {
		grid = new JButton[42];
		player = 1;
		isWinner = isDraw = exit = newGame = false;
		board = new InternalBoard();
		logic = new InternalLogic(board);
		setLayout(new GridLayout(6, 7, 2, 2));

		icon = new ImageIcon("connectFour.jpg");
		for (int i = 0; i < 42; i++) {
			grid[i] = new JButton();
			grid[i].setBorder(new LineBorder(Color.BLACK));
			grid[i].setActionCommand("" + i); // not sure if this is the same as
												// new JButton(" + i);
			grid[i].setBackground(Color.GRAY);
			grid[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int i = Integer.parseInt(e.getActionCommand());
					int y = i % 7;
					int x = board.findNextX(y);
					if (x != -1) {
						i = x * 7 + y;
						grid[i].setBackground(player == 1 ? Color.RED
								: Color.BLUE);
						if (logic.playerMove(x, y, player)) { // is there a
																// winner
							isWinner = true;
						} else if (logic.draw()) { // is there a draw
							isDraw = true;
						} else {
							changePlayer();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Column is filled",
								"Choose another column",
								JOptionPane.INFORMATION_MESSAGE, icon);
					}

				}

			});
			add(grid[i]);
		}
	}

	private void changePlayer() {
		player = player == 1 ? 2 : 1;
	}

	public int showWin() {
		String color = player == 1 ? "Red" : "Blue";
		StringBuilder winner = new StringBuilder();
		winner.append(color);
		winner.append(" wins");
		int n = JOptionPane.showConfirmDialog(this, "New Game?",
				winner.toString(), JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, icon);
		if (n > 1) {
			newGame = true;
		} else {
			exit = true;
		}
		return n;
	}

	public int draw() {
		String draw = "It's a draw";
		int n = JOptionPane.showConfirmDialog(this, "New Game?", draw,
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
		if (n > 1) {
			newGame = true;
		} else {
			exit = true;
		}
		return n;
	}

	public int getPlayer() {
		return player;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public boolean exit() {
		return exit;
	}

	public boolean newGame() {
		return newGame;
	}

}
