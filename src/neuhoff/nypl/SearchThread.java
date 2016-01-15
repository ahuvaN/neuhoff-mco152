package neuhoff.nypl;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;




import com.google.gson.Gson;

public class SearchThread extends Thread{
	private String search;
	private JLabel label;
	private ArrayList<String> titles;
	private String[] resultTitles;
	private NYPL nypl;
	private Result[] results;
	private NYPLJFrame frame;
	private JList<String> list;

	public SearchThread(String look, JLabel jLabel, NYPLJFrame parent, JList<String> titlesList) {
		search = look;
		label = jLabel;
		nypl = null;
		titles = new ArrayList<String>();
		results = null;
		frame = parent;
		list = titlesList;
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
			
			for(int i = 0; i < results.length; i++){
				String titleResult = results[i].getTitle();
				if (titleResult.length() > 30){
					titleResult = titleResult.substring(0, 30);
				}
				titles.add(titleResult);
				String apiItemurl = results[i].getApiItemURL();	
				
				/*PictureThread thread = new PictureThread();
				thread.start();*/
			}
			
			resultTitles = new String[titles.size()];
			titles.toArray(resultTitles);
			
			list.setListData(resultTitles);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String[] getTitles(){
		return resultTitles;
	}

}
