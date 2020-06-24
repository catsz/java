import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class isAnagram {
	public static Scanner in = new Scanner(System.in);
	
	public static int getCIndex(char C) {
		int rtn = 0;
		
		for (char i = 'a'; i != C; i++) {
			rtn++;
		}
		
		return rtn;
	}
	
	public static int[] letterHist(String hist) {
		int[] rtn = new int[25];
		
		for (char var : hist.toLowerCase().toCharArray()) {
			rtn[getCIndex(var)] = rtn[getCIndex(var)]+ 1;
		}
		
		return rtn;
	}
	
	public static boolean isAnagram(String x1, String n1) {
		boolean rtn = true;
		
		for (int i = 0; i < letterHist(x1).length; i++) {
			int[] x = letterHist(x1);
			int[] n = letterHist(n1);
			
			if (x[i] != n[i]) {
				rtn = false;
			}
		}
		
		return rtn;
	}
	
	public static void main(String[] args) {
		System.out.print("Input a string: ");
		String x1 = in.next();
		System.out.print("Input another string and I will tell you if they are anagrams: ");
		String n1 = in.next();
		
		if (isAnagram(x1, n1)) {
			System.out.print("Those two words are anagrams");
		} else {
			System.out.print("Those two words aren't anagrams");
		}
	}
}