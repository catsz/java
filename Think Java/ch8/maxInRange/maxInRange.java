import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class maxInRange {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a integer please input a integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static int maxInRange(int[] n, int x, int y) {
		
		if (x == y && n.length - 1 >= x) {
			return n[x];
		} else if (n.length - 1 >= y) {
			int recurse = maxInRange(n, x, y - 1);
			if (recurse < n[y]) {
				return n[y];
			} else {
				return recurse;
			}
		}
		return 0;
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
	
	public static void main(String[] args){
		System.out.print("Input a int array: ");
		int[] n = STI(in.next());
		System.out.print("Input the lowest range you would like me to get the max number of: ");
		int x = nextI();
		System.out.print("Input the highest range you would like me to get the max number of: ");
		int y = nextI();
		
		System.out.print("The highest number in that range is: " + maxInRange(n, x, y));
	}
}