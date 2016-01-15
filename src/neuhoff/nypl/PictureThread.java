package neuhoff.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class PictureThread extends Thread {
	private String stringUrl;
	private NYPL nypl;

	public PictureThread(String urlAddress) {
		stringUrl = urlAddress;
	}

	public void run() {
		URL url;
		try {
			url = new URL(stringUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();

			nypl = gson.fromJson(br, NYPL.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Capture[] getCaptures(){
		return nypl.getCaptures();
	}
}
