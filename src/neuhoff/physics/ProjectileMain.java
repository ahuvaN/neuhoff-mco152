package neuhoff.physics;

public class ProjectileMain {
	public static void main(String[] args) {

		Projectile value = new Projectile(31, 20, 0);

		for (int x = 0; x <= 10; x++) {
			System.out.println("Time= " + value.getTime());
			System.out.println("x= " + value.getX());
			System.out.println("y= " + value.getY());
			value.setTime();
		}
	QuadraticEquation e = new QuadraticEquation(2, 6, 4);
	e.getPositiveX();
	}
}
