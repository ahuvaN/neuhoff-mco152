package neuhoff.weather;

public class CurrentWeather {
	private Weather[] weather;
	private Main main;
	private Clouds clouds;
	private String name;

	public Weather[] getWeather() {
		return weather;
	}

	public Main getMain() {
		return main;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public String getName() {
		return name;
	}
}
