import java.util.Scanner;
import java.math.BigInteger;

public class BigPow {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextInt()) {
			System.out.printf("%s is not a integer please input integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}
	
	public static BigInteger pow(int a, int b) {
		BigInteger save = BigInteger.valueOf(1);
		
		for (int i = 0; i < b; i++) {
			save = save.multiply(BigInteger.valueOf(a));
		}
		return save;
	}
	
	public static void main(String[] args) {
		System.out.print("Input integer you would like to raise a power to: ");
		int a = nextI();
		System.out.print("Input integer you would like to be the power: ");
		int b = nextI();
		System.out.print(pow(a, b).toString());
	}
}