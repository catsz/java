import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class indexOfMax {
	public static Scanner in = new Scanner(System.in);
	
	public static int indexOfMax(int[] findM) {
		List<Integer> FMList = new ArrayList<Integer>();
		int max = 0;
		
		for (Integer var : findM) {			
			FMList.add(var);
		}
		
		for (Integer var: FMList) {
			
			if (max < var.intValue()) {
				max = var.intValue();
			}
		}
		return FMList.indexOf(max);
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
	
	
	
	
	
	
	
	
	
	
	
	public static int[] STI_griffin(String s) {
		List<Integer> rtn1 = new ArrayList<Integer>();
		List<Integer> rtn2 = new ArrayList<Integer>();
		char[] ints = s.toCharArray();
		int[] rtn3;
		
		for (int i = 0; i < ints.length; i++) {
			try {
				rtn1.add(Integer.parseInt(Character.toString(ints[i])));
			} catch (Exception ex) {
				try {
			String end = "";
				
				for (Integer var : rtn1) {
					String var2 = Integer.toString(var.intValue());
					end = end + var2;
				}
				
				rtn1 = new ArrayList<Integer>();
				rtn2.add(Integer.parseInt(end));
		} catch (Exception ex9) {
			
		}
			}
		}
		
		
		try {
			String end = "";
				
				for (Integer var : rtn1) {
					String var2 = Integer.toString(var.intValue());
					end = end + var2;
				}
				rtn1 = new ArrayList<Integer>();
				rtn2.add(Integer.parseInt(end));
		} catch (Exception ex10) {
			System.out.print("fail");
		}
		
		
		rtn3 = new int[rtn2.size()];
		
		for (int i1 = 0; i1 < rtn2.size(); i1++) {
			rtn3[i1] = rtn2.get(i1);
		}
		
		return rtn3;
	}
	
	public static void main(String[] args){
		
		System.out.print("Input array and I will find the index of the highest number: ");
		int[] maxIndex = STI(in.next());
		System.out.printf("The index of the highest number is: %d", indexOfMax(maxIndex));
	}
}