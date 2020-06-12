import java.util.Scanner;


public class SquareRoot {
	public static Scanner in = new Scanner(System.in);
	
	public static double nextD() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a double please input integer: ", in.next());
			return nextD();
		} else {
			return in.nextDouble();
		}
	}
	
	public static double SQRT(double a) {
		double n = a/2;
		double x1 = (n + a/n)/2;
		double x2 = (n + a/n)/22;
		
		boolean swap = true;
		while (true) {
			
				if (swap) {
				
				x1 = (x2 + a/x2)/2;
				swap = false;
			} else {
				
				x2 = (x1 + a/x1)/2;
				swap = true;
			}
			
			if (Math.abs(x1 - x2) <= 0.0001) {
				break;
			}
		}
		return Math.floor(x1);
		
		/* better way
		double x1 = a/2;
		double x2 = (n + a/n)/22;
		
		while (true) {
				
				x2 = (x1 + a/x1)/2;
			
			if (Math.abs(x1 - x2) <= 0.0001) {
				break;
			}
			
			x1 = x2;
		}
		return Math.floor(x1);
		
		*/
	}

    public static void main(String[] args){
		System.out.print("Please input a number to be square rooted: ");
		double squareR = nextD();
		System.out.printf("The square root using math.sqrt is: %f", Math.floor(Math.sqrt(squareR)));
		System.out.printf("The square root is: %f\n", SQRT(squareR));
	}
}