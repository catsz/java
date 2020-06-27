import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bottle99 {
	
	public static void Bottles(int x) {
		int start = x;
		
		if (start > 0) {
			System.out.println(start + " bottles of beer on the wall, " + start + " bottles of beer, ya' take one down, ya' pass it around, " + (start - 1) + " bottles of beer on the wall.");
			Bottles(start - 1);
		} else {
			System.out.print("No bottles of beer on the wall, no bottles of beer, ya' can't take one down, ya' can't pass it around, 'cause there are no more bottles of beer on the wall!");
		}
		
	}
	
	public static void main(String[] args){
		Bottles(99);
	}
}