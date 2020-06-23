import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class letterHist {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a int please input int: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
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
	
	public static void main(String[] args) {
		System.out.print("Input string to be turned into a histogram: ");
		String hist = in.next();
		System.out.print(Arrays.toString(letterHist(hist)));
	}
}