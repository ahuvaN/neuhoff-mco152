package neuhoff.nypl;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class PictureThread extends Thread {
	private String stringUrl;
	private JLabel pic;
	private NYPL nypl;
	private Capture[] captures;
	private String[] images;
	private int position;

	public PictureThread(String urlAddress, JLabel picture, String[] shots, int pos) {
		stringUrl = urlAddress;
		pic = picture;
		images = shots;
		position = pos;
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
			int size = nypl.getCaptures().length;

			captures = new Capture[size];
			captures = nypl.getCaptures();
			images = new String[size];
			for (int i = 0; i < size; i++){
				images[i] = captures[i].getURL();
			}
			Image image = null;
	        try {
	            URL imageUrl = new URL(images[0]);
	            image = ImageIO.read(url);
	            pic.setIcon(new ImageIcon(image));
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	        
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
