import java.util.Scanner;
import java.math.BigInteger;

public class math {
	public static Scanner in = new Scanner(System.in);
	
	public static double factorial(double a) {
		double save = 1;
		
		for (double i = a; i > 0; i--) {
			save = i * save;
		}
		return save;
	}
	
	public static double myexp(double x, double n) {
		double rtn = 0;
		
		for (double i = 0; i < n; i++) {
			rtn = rtn + (Math.pow(x, i) / factorial(i));
		}
		return rtn;
	}
	
	public static String check(double x, double n) {
		String rtn = x + "\t" + Math.exp(x) + "\t" + myexp(x, n);
		return rtn;
	}
	
	public static void main(String[] args) {
		
		double use = 0.1;
		for (int i = 0; i < 4; i++) {
			System.out.println(check(use, 15));
			use = use * 10;
		}
		
		double use1 = -0.1;
		for (int i = 0; i < 3; i++) {
			
			System.out.println(check(use1, 15));
			use1 = use1 * 10;
		}
		System.out.print(check(-100, 15));
	}
}