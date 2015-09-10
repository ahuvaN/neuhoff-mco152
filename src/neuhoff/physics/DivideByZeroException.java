package neuhoff.physics;

public class DivideByZeroException extends Exception{
	public DivideByZeroException(){
		super("Cant divide by zero.");
	}
}
