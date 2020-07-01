import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ack {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a integer please input a integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (m > 0 && n == 0) {
			return ack(m - 1, 1);
		} else if (m > 0 && n > 0) {
			return ack(m - 1, ack(m, n - 1));
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		System.out.print("Input first value: ");
		int m = nextI();
		System.out.print("Input second value: ");
		int n = nextI();
		System.out.print("Output is: " + ack(m, n));
	}
}