package neuhoff.extendedWeather;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class EWThread extends Thread {

	private List[] list;
	private EWJPanel[] weather;
	private WeatherGui gui;
	private AccessWeather access;

	public EWThread(WeatherGui weatherGui) {
		gui = weatherGui;
		gui.centerJPanel = new CenterJPanel();
		gui.add(gui.centerJPanel, BorderLayout.CENTER);

		weather = gui.centerJPanel.weather;
		access = new AccessWeather();
	}

	public void run() {
		try {
			ExtendedWeather extended = access.getAccessWeather(gui.zipCode);
			gui.centerJPanel.city.setText(extended.getCity().getName());

			list = extended.getList();
			for (int i = 0; i < 16; i++) {
				weather[i].date.setText(list[i].getDate());
				String icon = "http://openweathermap.org/img/w/"
						+ list[i].getWeather()[0].getIcon() + ".png";
				URL url = new URL(icon);
				BufferedImage image = ImageIO.read(url);
				weather[i].icon.setIcon(new ImageIcon(image));
				weather[i].desc.setText(list[i].getWeather()[0]
						.getDescription());
				weather[i].hi.setText(String
						.valueOf(list[i].getTemp().getDay()) + "\u00b0");
				weather[i].low.setText("Lo "
						+ String.valueOf(list[i].getTemp().getNight())
						+ "\u00b0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
