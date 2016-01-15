package neuhoff.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JList;

import com.google.gson.Gson;

public class SearchThread extends Thread {
	private String search;
	private String[] titles, apiItemurl;
	private NYPL nypl;
	private Result[] results;
	private JList<String> list;

	public SearchThread(String look, JList<String> titlesList, String[] url) {
		search = look;
		nypl = null;
		results = null;
		list = titlesList;
		apiItemurl = url;
	}

	public void run() {

		String urlAddress = "http://api.repo.nypl.org/api/v1/items/search?q="
				+ search + "&publicDomainOnly=true";

		URL url;
		try {
			url = new URL(urlAddress);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestProperty("Authorization",
					"Token token=\"lo34z075x12dgfiw\"");

			InputStream in = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();

			nypl = gson.fromJson(br, NYPL.class);
			int size = nypl.getNyplApi().getResponse().getResults().length;

			results = new Result[size];
			results = nypl.getResults();
			apiItemurl = new String[size];
			titles = new String[size];
			for (int i = 0; i < results.length; i++) {
				titles[i] = results[i].getTitle();
				if (titles[i].length() > 30) {
					titles[i] = titles[i].substring(0, 30);
				}
				apiItemurl[i] = results[i].getApiItemURL();
			}

			list.setListData(titles);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String[] getURLS(){
		return apiItemurl;
	}

}
