package neuhoff.weather;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private JLabel zip, name, degrees, humidity, description, cloudCover;
	private JTextField inputZip;
	private String icon;
	
	public WeatherGUI() {
		setTitle("Weather GUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		Font f = new Font("Dialog", Font.PLAIN, 24);
		AccessWeather access = new AccessWeather();
		zip = new JLabel("Enter Zip Code:");
		zip.setFont(f);
		inputZip = new JTextField("                                        ");
		inputZip.setFont(f);
		name = new JLabel("City");
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		//name.setAlignmentY(Component.CENTER_ALIGNMENT);
		name.setFont(f);
		degrees = new JLabel("--\u00b0");
		degrees.setAlignmentX(Component.CENTER_ALIGNMENT);
		degrees.setFont(f);
		humidity = new JLabel("Humidity");
		humidity.setAlignmentX(Component.CENTER_ALIGNMENT);
		humidity.setFont(f);
		description = new JLabel("Description");
		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		description.setFont(f);
		cloudCover = new JLabel("Cloud Cover");
		cloudCover.setAlignmentX(Component.CENTER_ALIGNMENT);
		cloudCover.setFont(f);

		Container pageStart = new Container();
		pageStart.setLayout(new FlowLayout());

		Container center = new Container();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		Container lineStart = new Container();
		lineStart.setLayout(new BoxLayout(lineStart, BoxLayout.Y_AXIS));

		Container lineEnd = new Container();
		lineEnd.setLayout(new BoxLayout(lineEnd, BoxLayout.Y_AXIS));

		pageStart.add(zip);
		pageStart.add(inputZip);
		
		center.add(name);
		center.add(degrees);
		
		lineStart.add(humidity);
		lineStart.add(cloudCover);
		lineEnd.add(description);
		
	
		container.add(pageStart, BorderLayout.PAGE_START);
		container.add(center, BorderLayout.CENTER);
		container.add(lineStart, BorderLayout.LINE_START);
		container.add(lineEnd, BorderLayout.LINE_END);

		JLabel label = new JLabel();
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					CurrentWeather weather = access.getAccessWeather(inputZip
							.getText().trim());
					name.setText(weather.getName());
					degrees.setText(weather.getMain().getTempInFarenheit()
							.toString()
							+ "\u00b0");
					icon = weather.getWeather()[0].getIcon();
					StringBuffer sb = new StringBuffer();
					sb.append("http://openweathermap.org/img/w/");
					sb.append(icon);
					sb.append(".png");
					URL url = new URL(sb.toString());
					BufferedImage image = 
					enlarge(ImageIO.read(url), 2);
					label.setIcon(new ImageIcon(image));
					lineEnd.add(label);
					humidity.setText("<html> humidity<br> "
							+ String.valueOf(weather.getMain().getHumidity())
							+ "%</html>");
					description.setText(weather.getWeather()[0]
							.getDescription());
					cloudCover.setText("<html><br>Cloud coverage<br>  "
							+ String.valueOf(weather.getClouds().getAll())
							+ "</html>");
				} catch (IOException e) {
					zip.setText("Invalid Zip");
					inputZip.setText("");
				}

			}

		};
		inputZip.addActionListener(action);

	}

	private BufferedImage enlarge(BufferedImage image, int n) {
        
       int w = n * image.getWidth();
       int h = n * image.getHeight();
        
       BufferedImage enlargedImage =
               new BufferedImage(w, h, image.getType());
        
       for (int y=0; y < h; ++y)
           for (int x=0; x < w; ++x)
               enlargedImage.setRGB(x, y, image.getRGB(x/n, y/n));
        
       return enlargedImage;
   }
	
	public static void main(String[] args) {
		WeatherGUI gui = new WeatherGUI();
		gui.setVisible(true);
	}
}
