import java.util.Scanner;


public class isAbecedarian {
	public static Scanner in = new Scanner(System.in);
	
	public static boolean abecedarian(String x) {
		char[] n = x.toCharArray();
		boolean isA = true;
		
		for (int i = 0; i < x.length() - 1; i++) {
			
			if (!((int) n[i] < (int) n[i + 1])) {
				isA = false;
				break;
			}
		}
		return isA;
	}
	
    public static void main(String[] args){
		System.out.print("Input a word and I will tell you if it is abecedarian or not: ");
		if (abecedarian(in.next())) {
			System.out.print("That word is abecedarian");
		} else {
			System.out.print("That word is not abecedarian");
		}
	}
}