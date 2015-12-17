package neuhoff.extendedWeather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {

	private JLabel zip;
	private JTextField inZip;
	protected CenterJPanel centerJPanel;
	protected String zipCode;

	public WeatherGui() {
		setTitle("Weather Forecast");
		setSize(1360, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		Font f = new Font("Dialog", Font.PLAIN, 24);
		zip = new JLabel("Enter Zip Code:");
		zip.setFont(f);
		inZip = new JTextField("          ");
		inZip.setFont(f);

		Container pageStart = new Container();
		pageStart.setLayout(new FlowLayout());
		pageStart.add(zip);
		pageStart.add(inZip);
		add(pageStart, BorderLayout.PAGE_START);

		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				zipCode = inZip.getText().trim();
				EWThread thread = new EWThread(WeatherGui.this);
				thread.start();

			}

		};
		inZip.addActionListener(action);

	}

	public static void main(String[] args) {
		WeatherGui gui = new WeatherGui();
		gui.setVisible(true);
	}
}
