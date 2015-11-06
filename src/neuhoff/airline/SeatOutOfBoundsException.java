package neuhoff.airline;

public class SeatOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1L;
	public SeatOutOfBoundsException(){
		super("Specified seat does not exist on this aircraft.");
	}

}
