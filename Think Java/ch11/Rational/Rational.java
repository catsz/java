

public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public static void printRational(Rational ratio) {
		System.out.printf("%d/%d\n", ratio.getNumerator(), ratio.getDenominator());
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	public void setDenominator(int Denominator) {
		this.denominator = Denominator;
	}
	
	public void setNumerator(int Numerator) {
		this.numerator = Numerator;
	}
	
	public static void main(String[] args) {
		Rational ratio = new Rational();
		ratio.setNumerator(5);
		ratio.setDenominator(10);
		
		Rational.printRational(ratio);
	}
}