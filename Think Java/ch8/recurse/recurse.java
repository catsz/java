import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class recurse {
	public static Scanner in = new Scanner(System.in);
	
	public static char first(String s) {
    return s.charAt(0);
	}
	
	public static String rest(String s) {
    return s.substring(1);
	}
	
	public static String middle(String s) {
    return s.substring(1, s.length() - 1);
	}
	
	public static int length(String s) {
    return s.length();
	}
	
	public static void printString(String s) {
		String s1 = s;
		
		while (length(s1) > 1) {
			System.out.println(first(s1));
			s1 = rest(s1);
		}
		System.out.print(s1);
	}
	
	public static void printBackwards(String s) {
		String s1 = s;
		char[] s2 = new char[length(s)];
		
		int i1 = length(s1) - 1;
		while (i1 > 0) {
			s2[i1] = first(s1);
			s1 = rest(s1);
			i1 = length(s1) - 1;
		}
		s2[i1] = s1.charAt(0);
		
		for (int i = 0; i < s2.length - 1; i++) {
				System.out.println(s2[i]);
		}
		System.out.print(s2[s2.length - 1]);
	}
	
	public static String reverseString(String s) {
		String s1 = s;
		char[] s2 = new char[length(s)];
		
		int i1 = length(s1) - 1;
		while (i1 > 0) {
			s2[i1] = first(s1);
			s1 = rest(s1);
			i1 = length(s1) - 1;
		}
		s2[i1] = s1.charAt(0);
		
		return new String(s2);
	}
	
	public static boolean isPalindrome(String s) {
		if (length(s) == 1 || length(s) == 2) {
			if (length(s) == 2) {
				if (first(s) == s.charAt(1)) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			boolean recurse = isPalindrome(middle(s));
			if (recurse && first(s) == s.charAt(length(s) - 1)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.print(isPalindrome("yeey"));
	}
}