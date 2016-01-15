package neuhoff.nypl;


public class Capture {
	private ImageLinks imageLinks;

	public ImageLinks getImageLinks() {
		return imageLinks;
	}
	
	public String getURL(){
		return imageLinks.getImageLink();
	}
}
