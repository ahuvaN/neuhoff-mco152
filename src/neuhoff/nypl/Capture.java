package neuhoff.nypl;

public class Capture {
	private ImageLinks imageLinks;

	public String getImageLinkURL() {
		return imageLinks.getImageLinks()[4].getUrl();
	}
}
