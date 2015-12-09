package neuhoff.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

public class AccessWeather {

	public CurrentWeather getAccessWeather(String zipCode) throws IOException{
	//public static void main(String[] args) throws IOException {
		String zip = zipCode;
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		CurrentWeather current = gson.fromJson(br, CurrentWeather.class);
		return current;
		//String description = weather.getDescription();
		//System.out.println(description);
		
	}
	
	//}
}