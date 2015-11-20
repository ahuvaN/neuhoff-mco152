package neuhoff.pi;

public class CalculatePI {

	public static void main(String[] args) {
		
		PiCalculator calc = new PiCalculator();
		double sum = calc.calculate(5000000L);
		
		System.out.println(sum);

	}
}
