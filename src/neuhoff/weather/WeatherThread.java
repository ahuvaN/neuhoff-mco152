package neuhoff.weather;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WeatherThread extends Thread {

	private String zipCode;
	private JLabel name, degrees, humidity, description, cloudCover, label;
	private AccessWeather access;

	public WeatherThread(String zip, JLabel name, JLabel degrees,
			JLabel humidity, JLabel description, JLabel cloudCover, JLabel label) {
		this.zipCode = zip;
		this.name = name;
		this.degrees = degrees;
		this.humidity = humidity;
		this.description = description;
		this.cloudCover = cloudCover;
		this.label = label;
		access = new AccessWeather();
	}

	public void run() {
		try {
			CurrentWeather weather = access.getAccessWeather(zipCode);

			name.setText(weather.getName());
			degrees.setText(weather.getMain().getTempInFarenheit().toString()
					+ "\u00b0");
			String icon = weather.getWeather()[0].getIcon();
			StringBuffer sb = new StringBuffer();
			sb.append("http://openweathermap.org/img/w/");
			sb.append(icon);
			sb.append(".png");
			URL url = new URL(sb.toString());

			BufferedImage image = ImageIO.read(url);
			label.setIcon(new ImageIcon(image));
			humidity.setText("Humidity: "
					+ String.valueOf(weather.getMain().getHumidity()) + "%");
			description.setText(weather.getWeather()[0].getDescription());
			cloudCover.setText("Cloud Cover: "
					+ String.valueOf(weather.getClouds().getAll()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
