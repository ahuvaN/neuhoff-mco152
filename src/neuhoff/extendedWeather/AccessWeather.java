package neuhoff.extendedWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class AccessWeather {

	public ExtendedWeather getAccessWeather(String zipCode) throws IOException {

		String urlAddress = "http://api.openweathermap.org/data/2.5/forecast/"
				+ "daily?zip="
				+ zipCode
				+ "&cnt=16&appid=b65b2b490380de20e8b12eb10dd85fb6&units=imperial";

		URL url = new URL(urlAddress);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		return gson.fromJson(br, ExtendedWeather.class);
	}

}
