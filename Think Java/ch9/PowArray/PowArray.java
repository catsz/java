import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowArray {
	public static Scanner in = new Scanner(System.in);
	
	public static double[] PowArray(double[] a) {
		double[] rtn = new double[a.length];
		
		for (int i = 0; i < a.length; i++) {
			rtn[i] = Math.pow(a[i], 2);
		}
		return rtn;
	}
	
	public static int[] histogram(int[] a) {
		int[] rtn = new int[100];
		
		for (int i = 0; i < rtn.length; i++) {
			
			for (int value : a) {
				if (value == i) {
					rtn[i]++;
				}
			}
		}
		return rtn;
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
	
	public static double[] STID(String s) {
		List<Double> rtn = new ArrayList<Double>();
		double[] rtn2;

		for (String retval: s.split(",")) {
         
		 try {
			double v = Double.parseDouble(retval);
		    rtn.add(v);
		 } catch (Exception ex) {
		 }
        }
		rtn2 = new double[rtn.size()];
		for (int i1 = 0; i1 < rtn.size(); i1++) {
			rtn2[i1] = rtn.get(i1);
		}
		return rtn2;

	}
	
	public static void main(String[] args) {
		System.out.print("Input array for a histogram: ");
		int[] a = STI(in.next());
		System.out.println(Arrays.toString(histogram(a)));
		
		System.out.print("Input array to be squared: ");
		double[] n = STID(in.next());
		System.out.print(Arrays.toString(PowArray(n)));
	}
}