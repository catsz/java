import java.util.Scanner;
import java.math.BigInteger;
import java.util.List;

public class big {
	public static Scanner in = new Scanner(System.in);
	
	public static BigInteger factorial(BigInteger a) {
		BigInteger save = BigInteger.valueOf(1);
		for (long i = a.longValue(); i > 0; i--) {
			save = save.multiply(BigInteger.valueOf(i));
		}
		return save;
	}
	
	 public static void main(String[] args){
		 BigInteger[] BigIntegers = new BigInteger[31];
		 BigInteger[] factorial = new BigInteger[31];
		 for (int i = 0; i < BigIntegers.length; i++) {
			 BigIntegers[i] = BigInteger.valueOf(i);
		 }
		 for (int i = 0; i < factorial.length; i++) {
			 factorial[i] = factorial(BigIntegers[i]);
		 }
		 for (int i = 0; i < BigIntegers.length - 1; i++) {
			 BigInteger x = BigIntegers[i];
			 BigInteger y = factorial[i];
			 System.out.println(x.toString() + ":" + y.toString());
		 }
		BigInteger x = BigIntegers[BigIntegers.length - 1];
		BigInteger y = factorial[BigIntegers.length - 1];
		 System.out.print(x.toString() + ":" + y.toString());
	 }
	 
}