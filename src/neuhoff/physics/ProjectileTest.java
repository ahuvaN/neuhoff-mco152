package neuhoff.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {
	
	@Test
	public void testGetX() {
		Projectile p = new Projectile(31, 20, 2.7);
		double x = p.getX();
		
		Assert.assertEquals(27.81, x, 0.01);
	}
	
	@Test
	public void testGetY() {
		Projectile p = new Projectile(31, 20, 2.7);
		double y = p.getY();
		
		Assert.assertEquals(10.56, y, 0.01);
	}
}

