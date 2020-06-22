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
		List<Integer> rtn = new ArrayList<Integer>();
		int[] rtn2;

		for (String retval: s.split(",")) {
         
		 try {
			int v = Integer.parseInt(retval);
		    rtn.add(v);
			System.out.println(retval);
		 } catch (Exception ex) {
		 }
        }
		rtn2 = new int[rtn.size()];
		for (int i1 = 0; i1 < rtn.size(); i1++) {
			rtn2[i1] = rtn.get(i1);
		}
		return rtn2;

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