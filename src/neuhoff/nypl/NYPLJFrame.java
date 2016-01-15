package neuhoff.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import neuhoff.contacts.Contact;
import neuhoff.contacts.ContactInfoGui;

public class NYPLJFrame extends JFrame {

	private JTextField inputText;
	private JButton button, prev, next;
	private volatile JLabel label, picture;
	private JList<String> list;
	private volatile String[] url, captures;
	private int position, imgPos;

	public NYPLJFrame() {
		setTitle("NYPL");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		inputText = new JTextField();
		button = new JButton("Search");
		prev = new JButton("<");
		label = new JLabel();
		next = new JButton(">");
		prev.setEnabled(false);
		next.setEnabled(false);
		picture = new JLabel();
		url = new String[10];
		captures = new String[0];
		position = imgPos = 0;

		Container PageStart = new Container();
		PageStart.setLayout(new BorderLayout());
		PageStart.add(inputText, BorderLayout.CENTER);
		PageStart.add(button, BorderLayout.LINE_END);

		add(PageStart, BorderLayout.PAGE_START);
	
		list = new JList<String>();
		add(new JScrollPane(list), BorderLayout.LINE_START);
		
		Container center = new Container();
		center.setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
		
		Container cntrPS = new Container();
		cntrPS.setLayout(new FlowLayout());
		cntrPS.add(prev);
		cntrPS.add(label);
		cntrPS.add(next);
		center.add(cntrPS, BorderLayout.PAGE_START);
		
		center.add(new JScrollPane(picture), BorderLayout.CENTER);
		
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String search = inputText.getText().trim();
				
				SearchThread thread = new SearchThread(search, list, url);
				thread.start();
				//url = thread.getURLS();
			}

		};
		inputText.addActionListener(action);
		button.addActionListener(action);
		
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				position = list.locationToIndex(mouseEvent
							.getPoint());
				
				PictureThread pics = new PictureThread(url[position], picture, 
						captures, position);
				pics.start();
				imgPos = 0;
				label.setText((imgPos + 1) + "/" + (captures.length + 1));
			}
		};
		list.addMouseListener(mouseListener);
		

		

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
