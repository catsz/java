import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class power {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a integer please input a integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static double nextD() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a double please input a double: ", in.next());
			return nextI();
		} else {
			return in.nextDouble();
		}
	}
	
	public static double power(double x, int n) {
		
		if (n < 0) {
			return 1 / power(x, Math.abs(n));
		}
		
		if (n == 1) {
			return x;
		} else if (n == 0) {
			return 1;
		} else if (n > 0) {
			return x * power(x, n - 1);
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		System.out.print("Input number: ");
		double x = nexD();
		System.out.print("Input exponet for the number: ");
		int n = nextI();
		System.out.print(power(x, n));
	}
}