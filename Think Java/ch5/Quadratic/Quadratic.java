import java.util.Scanner;

public class Quadratic {
	public static Scanner in = new Scanner(System.in);
	
	public static double[] quadroots(double a, double b, double c) {
		
		if (a == 0 || Math.pow(b, 2) - 4 * a * c < 0) {
			System.out.print("Cannot use inputted numbers. Exiting program.");
			System.exit(0);
		}
		
		double[] rtn = {(b - Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a), (b + Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a)};
		
		return rtn;
	}
	
	public static double nextD() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a double please input double: ", in.next());
			return nextD();
		} else {
			return in.nextDouble();
		}
	}
	
	public static void main(String[] args) {
		double a = 0;
		double b = 0;
		double c = 0;
		
		
		for (int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
				System.out.print("Please input int for a: ");
				a = nextD();
				break;
				case 1:
				System.out.print("Please input int for b: ");
				b = 0 - nextD();
				break;
				case 2:
				System.out.print("Please input int for c: ");
				c = nextD();
				break;
			}
		}
	
	double[] x = quadroots(a, b, c);
	System.out.println("The quadratic roots are: ");
	for (int i = 0; i < 2; i++) {
		
		switch (i) {
			case 0:
			System.out.println("Negative root: " + x[0]);
			break;
			case 1:
			System.out.print("Positive root: " + x[1]);
		}
	}
	
	}
}