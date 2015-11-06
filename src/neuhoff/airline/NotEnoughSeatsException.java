package neuhoff.airline;

public class NotEnoughSeatsException extends Exception {

	private static final long serialVersionUID = 1L;
	public NotEnoughSeatsException(){
		super("There are not enough seats on the plane.");
	}

}
