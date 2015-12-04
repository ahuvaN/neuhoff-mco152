package neuhoff.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String t;
		while ((t = br.readLine()) != null) {
			System.out.println(t);
		}
		br.close();
	}

}
