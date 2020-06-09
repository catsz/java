import java.util.Scanner;


public class Fermat {

	public static boolean FermTorF(int a, int b, int c, int n) {
		if (Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) {
			return true;
		} else {
			return false;
		}
	}

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		int n = 0;
		
		for (int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
				System.out.print("Please input int for a: ");
				a = in.nextInt();
				break;
				case 1:
				System.out.print("Please input int for b: ");
				b = in.nextInt();
				break;
				case 2:
				System.out.print("Please input int for c: ");
				c = in.nextInt();
				break;
				case 3:
				System.out.print("Please input int for n: ");
				n = in.nextInt();
				break;
			}
		}
		
		if (FermTorF(a, b, c, n)) {
			System.out.print("Holy smokes, Fermat was wrong!");
		} else {
			System.out.print("No, that doesn\'t work.");
		}
	}
}