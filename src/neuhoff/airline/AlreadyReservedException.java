package neuhoff.airline;

public class AlreadyReservedException extends Exception {

	private static final long serialVersionUID = 1L;
	public AlreadyReservedException(){
		super("Specified seat is already reserved.");
	}
}
