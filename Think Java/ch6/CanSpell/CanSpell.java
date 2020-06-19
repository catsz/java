import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CanSpell {
	public static Scanner in = new Scanner(System.in);
	
	public static boolean canspell(String tiles, String word) {
		List<Character> Tlist = new ArrayList<Character>();
		char[] Sarray = word.toLowerCase().toCharArray();
		boolean rtn = true;
		
		for (Character var : tiles.toLowerCase().toCharArray()) {			
			Tlist.add(var);
		}
		
		for (Character v : Sarray) {
			
			if (Tlist.contains(v)) {
				Tlist.remove(v);
				continue;
			}
			rtn = false;
		}
		return rtn;
		
	}
	
	public static void main(String[] args){
		
		System.out.print("Input tiles: ");
		String tiles = in.next();
		System.out.print("Input word: ");
		String word = in.next();
		
		if (canspell(tiles, word)) {
			System.out.printf("You can spell '%s'.", word);
		} else {
			System.out.printf("You can't spell '%s'.", word);
		}
	}
}