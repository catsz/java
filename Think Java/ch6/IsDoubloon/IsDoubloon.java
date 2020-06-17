import java.util.Scanner;


public class IsDoubloon {
	public static Scanner in = new Scanner(System.in);
	
	public static boolean doubloon(String x) {
		char[] n = x.toLowerCase().toCharArray();
		boolean rtn = true;
		
		for (int i = 0; i < x.length(); i++) {
			char z = n[i];
			int am = 0;
			
			for (int i1 = 0; i1 < x.length(); i1++) {
				if (z == n[i1]) {
					am++;
				}
			}
			
			if (am != 2) {
				rtn = false;
			}
		}
		return rtn;
	}
	
    public static void main(String[] args){
		System.out.print("Input a word and I will tell you if it is doubloon or not: ");
		if (doubloon(in.next())) {
			System.out.print("That word is doubloon");
		} else {
			System.out.print("That word is not doubloon");
		}
	}
}