import java.util.Scanner;


public class Gauss {
	public static Scanner in = new Scanner(System.in);
	
	public static double nextD() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a double please input double: ", in.next());
			return nextD();
		} else {
			return in.nextDouble();
		}
	}
	
	public static double pow(double a, double b) {
		double save = 1;
		
		for (int i = 0; i < b; i++) {
			save = save * a;
		}
		return save;
	}
	// 5! = 5*4*3*2*1 = 120
	public static double factorial(double a) {
		double save = 1;
		
		for (double i = a; i > 0; i--) {
			save = i * save;
		}
		return save;
	}
	
	public static double gaus(double x, double n) {
		double save = 0;
		
		for (int i = 0; i < n; i++) {
			save = save + pow((-1), i) * pow(x, 2 * i) / factorial(i);
		}
		return save;
	}
	
    public static void main(String[] args){
		System.out.print("Please input a number one to be gaussed: ");
		double x = nextD();
		System.out.print("Please input the amount of times number one to be repeatedly gaussed: ");
		double n = nextD();
		System.out.print("Both those numbers gaussed is: " + gaus(x, n));
	}
}