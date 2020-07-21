import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Parentheses {
	public static Scanner in = new Scanner(System.in);
	
	public static boolean StringP(String s) {
		
		int count = 0;
		List<Integer> DUse = new ArrayList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
				for (int i1 = i; i1 < s.length(); i1++) {
					char b = s.charAt(i1);
					
					if (b == ')') {
						count--;
						DUse.add(i1);
						break;
					}
				}
			} else if (c == ')' && !DUse.contains(i)) {
				boolean run = true;
				
				for (int i2 = i; i2 < s.length(); i2++) {
					char b = s.charAt(i2);
					if (b == '(') {
						run = false;
					}
				}
				
				if (run) {
					count--;
				}
			}
		}
		return count == 0;
	}
	
	public static void main(String[] args){
		System.out.print("Input String with parentheses and I will tell you if all of them are closed or not: ");
		String s = in.next();
		System.out.print("If it is true then the parentheses are fine if it is false the parentheses aren't correct: " + StringP(s));
	}
}