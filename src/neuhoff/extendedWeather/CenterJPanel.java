package neuhoff.extendedWeather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CenterJPanel extends JPanel {

	protected JLabel city;
	protected EWJPanel[] weather;

	public CenterJPanel() {
		city = new JLabel();
		city.setFont(new Font("Dialog", Font.BOLD, 26));
		weather = new EWJPanel[16];
		setLayout(new BorderLayout());

		Container pageStart = new Container();
		pageStart.setLayout(new FlowLayout());
		pageStart.add(city);
		add(pageStart, BorderLayout.PAGE_START);

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 7, 1, 1));
		add(center, BorderLayout.CENTER);

		// add(city);
		for (int i = 0; i < 16; i++) {
			weather[i] = new EWJPanel();
			weather[i].setBorder(new LineBorder(Color.BLACK));
			center.add(weather[i]);
		}
	}

}
