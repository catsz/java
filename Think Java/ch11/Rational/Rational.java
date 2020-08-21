

public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public static void printRational(Rational ratio) {
		System.out.printf("%d/%d", ratio.getNumerator(), ratio.getDenominator());
	}
	
	public double toDouble() {
		double numerator = this.numerator;
		double denominator = this.denominator;
		return numerator / denominator;
	}
	
	private static int findGCD(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1%number2);
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
	
	public String toString() {
		return String.format("%d/%d", this.numerator, this.denominator);
	}
	
	public void negate() {
		if (numerator < 0) {
			this.numerator = Math.abs(this.numerator);
		} else {
			this.numerator = 0 - this.numerator;
		}
		if (denominator < 0) {
			this.denominator = Math.abs(this.denominator);
		} else {
			this.denominator = 0 - this.denominator;
		}
	}
	
	public void invert() {
		int setDenominator = this.numerator;
		
		this.numerator = this.denominator;
		this.denominator = setDenominator;
	}
	
	public boolean equals(Rational ratio) {
		if (this.toDouble() == ratio.toDouble()) {
			return true;
		} else {
			return false;
		}
	}
	
	public Rational reduce() {
		int GCD = findGCD(this.numerator, this.denominator);
		
		return new Rational(this.numerator / GCD, this.denominator / GCD);
	}
	
	public Rational add(Rational ratio) {
		Rational r1 = new Rational(this.numerator * ratio.getDenominator(), this.denominator * ratio.getDenominator());
		Rational r2 = new Rational(ratio.getNumerator() * this.denominator, this.denominator * ratio.getDenominator());
		Rational rtn = new Rational(r1.getNumerator() + r2.getNumerator(), this.denominator * ratio.getDenominator());
		
		
		return rtn.reduce();
	}
	
	public static void main(String[] args) {
		Rational r1 = new Rational(5, 10);
		Rational r2 = new Rational(8, 20);
		
		System.out.print(r1.add(r2));
	}
}