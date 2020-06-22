import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class arePrimeFactors {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a int please input int: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static int[] STI(String s) {
		List<Integer> rtn = new ArrayList<Integer>();
		int[] rtn2;

		for (String retval: s.split(",")) {
         
		 try {
			int v = Integer.parseInt(retval);
		    rtn.add(v);
		 } catch (Exception ex) {
		 }
        }
		rtn2 = new int[rtn.size()];
		for (int i1 = 0; i1 < rtn.size(); i1++) {
			rtn2[i1] = rtn.get(i1);
		}
		return rtn2;

	}
	
	public static boolean arePrimeFactors(int n, int[] array) {
		boolean APrime = true;
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == 1) {
				return false;
			}
			
			for (int i1 = array[i] - 1; i1 > 1; i1--) {
				if (!(array[i] % i1 > 0)) {
					APrime = false;
				}
			}
		}
		
		int m = 1;
		for (int i = 0; i < array.length; i++) {
			m = array[i] * m;
		}
		
		if (APrime && m == n) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args){
		System.out.print("Input array of primes: ");
		int[] array = STI(in.next());
		System.out.print("Input the product of the primes: ");
		int n = nextI();
		
		if (arePrimeFactors(n, array)) {
			System.out.printf("That array is prime numbers only and all the numbers are a product of %d", n);
		} else {
			System.out.printf("That array isn't prime numbers only and all the numbers aren't a product of %d", n);
		}
	}
}