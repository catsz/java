import java.util.Scanner;
import java.util.Arrays;


public class sieve {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a int please input int: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static boolean[] sieve(int n) {
		boolean[] rtn = new boolean[Math.abs(n)];
		
		for (int i = 0; i < rtn.length; i++) {
			rtn[i] = true;
		}
		
		for (int i = 0; i < rtn.length; i++) {
			
			if (i == 1 || i == 0) {
				rtn[i] = false;
				continue;
			}
			
			for (int i1 = i - 1; i1 > 1; i1--) {
				if (!(i % i1 > 0)) {
					rtn[i] = false;
				}
			}
		}
		
		return rtn;
	}
	
	public static void main(String[] args){
		System.out.print("Input the highest number you would like to know is prime: ");
		boolean[] prime = sieve(nextI());
		System.out.print(Arrays.toString(prime));
	}
}