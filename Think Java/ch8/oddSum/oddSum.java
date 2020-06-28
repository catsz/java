import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class oddSum {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a integer please input a integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static int oddSum(int odd) {
		int rtn = 0;
		
		if (odd % 2 == 0 || odd < 0) {
			return 0;
		}
		
		if (odd == 1) {
			return 1;
		} else {
			return oddSum(odd - 2) + odd;
		}
		
	}
	
	public static void main(String[] args){
		System.out.print("Input a positive odd integer: ");
		int odd = nextI();
		
		if (oddSum(odd) != 0) {
			System.out.printf("The sum of all odd numbers from 1 to %d is %d", odd, oddSum(odd));
		} else {
			System.out.print("That number is not odd or positive");
		}
		
	}
}