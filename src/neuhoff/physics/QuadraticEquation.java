package neuhoff.physics;

public class QuadraticEquation {

	private double a, b, c;

	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() throws ImaginaryNumberException,
			DivideByZeroException {
		if (a == 0) {
			throw new DivideByZeroException();
		} else if (b == 0) {
			throw new ImaginaryNumberException();
		}
		double x = (-b + (Math.sqrt((b * b) - 4 * a * c))) / (2 * a);
		return x;

	}

	public double getNegativeX() throws ImaginaryNumberException,
			DivideByZeroException {
		if (a == 0) {
			throw new DivideByZeroException();
		} else if (b == 0) {
			throw new ImaginaryNumberException();
		}
		double x = (-b - (Math.sqrt((b * b) - 4 * a * c))) / (2 * a);
		return x;
	}
}
