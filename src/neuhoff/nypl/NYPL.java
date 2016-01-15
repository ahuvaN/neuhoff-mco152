package neuhoff.nypl;

public class NYPL {
	private NyplAPI nyplAPI;

	
	public NyplAPI getNyplApi() {
		return nyplAPI;
	}

	public Result[] getResults(){
		return nyplAPI.getResponse().getResults();
	}
	
	public Capture[] getCaptures(){
		return nyplAPI.getResponse().getCaptures();
	}
}
