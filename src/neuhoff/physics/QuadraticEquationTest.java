package neuhoff.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() throws ImaginaryNumberException, DivideByZeroException {
		QuadraticEquation e = new QuadraticEquation(1, 5, 0);
		double x = e.getPositiveX();

		Assert.assertEquals(0.0, x, 0.01);
	}

	@Test
	public void testGetNegativeX() throws ImaginaryNumberException, DivideByZeroException {
		QuadraticEquation e = new QuadraticEquation(1, 5, 0);
		double x = e.getNegativeX();

		Assert.assertEquals(-5.0, x, 0.01);
	}
}
