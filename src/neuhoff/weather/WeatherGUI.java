package neuhoff.weather;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private JLabel zip, name, degrees, humidity, description, cloudCover,
			label;
	private JTextField inputZip;

	// private String icon;

	public WeatherGUI() {
		setTitle("Weather GUI");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		fillLayout();

		container.add(pageStart(), BorderLayout.PAGE_START);
		container.add(center(), BorderLayout.CENTER);
		container.add(lineStart(), BorderLayout.LINE_START);
		Container lineEnd = lineEnd();
		container.add(lineEnd, BorderLayout.LINE_END);

		label = new JLabel();
		lineEnd.add(label);
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String zip = inputZip.getText().trim();

				WeatherThread thread = new WeatherThread(zip, name, degrees,
						humidity, description, cloudCover, label);
				thread.start();

			}

		};
		inputZip.addActionListener(action);

	}

	private void fillLayout() {
		Font f = new Font("Dialog", Font.PLAIN, 24);
		zip = new JLabel("Enter Zip Code:");
		zip.setFont(f);
		inputZip = new JTextField("                                        ");
		inputZip.setFont(f);
		name = new JLabel("City");
		format(name, f);
		degrees = new JLabel("--\u00b0");
		format(degrees, f);
		humidity = new JLabel("Humidity");
		format(humidity, f);
		description = new JLabel("Description");
		format(description, f);
		cloudCover = new JLabel("Cloud Cover");
		format(cloudCover, f);
	}

	private Container pageStart() {
		Container pageStart = new Container();
		pageStart.setLayout(new FlowLayout());
		pageStart.add(zip);
		pageStart.add(inputZip);

		return pageStart;
	}

	private Container center() {
		Container center = new Container();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(name);
		center.add(degrees);
		return center;
	}

	private Container lineStart() {
		Container lineStart = new Container();
		lineStart.setLayout(new BoxLayout(lineStart, BoxLayout.Y_AXIS));
		lineStart.add(humidity);
		lineStart.add(cloudCover);
		return lineStart;
	}

	private Container lineEnd() {
		Container lineEnd = new Container();
		lineEnd.setLayout(new BoxLayout(lineEnd, BoxLayout.Y_AXIS));
		lineEnd.add(description);
		return lineEnd;
	}

	private void format(JLabel label, Font f) {
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(f);
	}

	public static void main(String[] args) {
		WeatherGUI gui = new WeatherGUI();
		gui.setVisible(true);
	}
}
