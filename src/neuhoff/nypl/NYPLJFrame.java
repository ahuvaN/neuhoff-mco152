package neuhoff.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class NYPLJFrame extends JFrame {

	private JTextField inputText;
	private JButton button, prev, next;
	private JLabel label;
	private JList<String> list;
	private ImageIcon picture;

	public NYPLJFrame() {
		setTitle("NYPL");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		inputText = new JTextField("                                       "
				+ "                                                           ");
		button = new JButton("Search");
		prev = new JButton("<");
		label = new JLabel("0/0");
		next = new JButton(">");
		prev.setEnabled(false);
		next.setEnabled(false);

		Container pageStart = new Container();
		pageStart.setLayout(new BorderLayout());

		Container psPageStart = new Container();
		psPageStart.setLayout(new FlowLayout());
		psPageStart.add(inputText);
		psPageStart.add(button);

		Container psCenter = new Container();
		psCenter.setLayout(new FlowLayout());
		psCenter.add(prev);
		psCenter.add(label);
		psCenter.add(next);

		pageStart.add(psPageStart, BorderLayout.PAGE_START);
		pageStart.add(psCenter, BorderLayout.CENTER);
		add(pageStart, BorderLayout.PAGE_START);
		
		Container center = new Container();
		list = new JList<String>();

		center.add(new JScrollPane(list), BorderLayout.LINE_START);
		
		picture = new ImageIcon();
		//pane = new JScrollPane(new JLabel(picture));
		center.add(new JScrollPane(new JLabel(picture)), BorderLayout.CENTER);
		add(center, BorderLayout.CENTER);
		

		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String search = inputText.getText().trim();

				SearchThread thread = new SearchThread(search, label,
						NYPLJFrame.this, list);
				thread.start();
			
			}

		};
		inputText.addActionListener(action);

		/*button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String search = inputText.getText().trim();
				SearchThread thread = new SearchThread(search, label,
						NYPLJFrame.this);
				thread.start();
				list.setListData(thread.getTitles());
				
			}

		});*/

		/*
		 * ActionListener previous = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if (numPic == 0) { numPic = 254; } else { numPic--; } URL url =
		 * images[numPic]; PictureDownload down = new PictureDownload(url, pic);
		 * down.start(); label.setText((numPic + 1) + " of 255"); }
		 * 
		 * };
		 * 
		 * ActionListener nextPic = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if (numPic == 254) { numPic = 0; } else { numPic++; } URL url =
		 * images[numPic]; PictureDownload down = new PictureDownload(url, pic);
		 * down.start(); label.setText((numPic + 1) + " of 255"); }
		 * 
		 * }; next.addActionListener(nextPic); prev.addActionListener(previous);
		 */

	}

	public static void main(String[] args) {
		NYPLJFrame nypl = new NYPLJFrame();
		nypl.setVisible(true);
	}
}
