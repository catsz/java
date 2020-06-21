import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class areFactors {
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
		List<Integer> rtn1 = new ArrayList<Integer>();
		int[] rtn3;

		for (String retval: s.split(",")) {
         
		 try {
		    rtn1.add(Integer.parseInt(retval));
		 } catch (Exception ex9) {
		 }
        }
		rtn3 = new int[rtn1.size()];
		for (int i1 = 0; i1 < rtn1.size(); i1++) {
			rtn3[i1] = rtn1.get(i1);
		}
		return rtn3;

	}
	
	public static boolean areFactors(int n, int[] x) {
		boolean rtn = true;
		
		for (int var : x) {
			if (n % var != 0) {
				rtn = false;
				break;
			}
		}
		return rtn;
	}
	
	public static void main(String[] args){
		System.out.print("Input a number: ");
		int divided = nextI();
		System.out.print("Input a array and I will find if all numbers can divide your last number: ");
		int[] divider = STI(in.next());
		
		if (areFactors(divided, divider)) {
			System.out.printf("%d can be divided by %s", divided, Arrays.toString(divider));
		} else {
			System.out.printf("%d can't be divided by %s", divided, Arrays.toString(divider));
		}
	}
}