package neuhoff.pythogoreanTheorem;

public class DivideByZeroException extends Exception{
	public DivideByZeroException(){
		super("Cant divide by zero.");
	}
}
