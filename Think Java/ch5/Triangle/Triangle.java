import java.util.Scanner;


public class Triangle {
	public static Scanner in = new Scanner(System.in);
	
	public static int nextI() {
		if (!in.hasNextDouble()) {
			System.out.printf("%s is not a integer please input integer: ", in.next());
			return nextI();
		} else {
			return in.nextInt();
		}
	}

    public static void main(String[] args) throws Exception {
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
				System.out.print("Please input int for a: ");
				a = nextI();
				break;
				case 1:
				System.out.print("Please input int for b: ");
				b = nextI();
				break;
				case 2:
				System.out.print("Please input int for c: ");
				c = nextI();
				break;
			}
		}
		
		if (a > (b + c) || b > (a + c) || c > (b + a) || a <= 0 || b <= 0 || c <= 0) {
			System.out.println("You cannot form a triangle with three sticks of those lengths.");
			throw new Exception("make an actual triangle");
		} else {
			System.out.println("You can form a triangle with three sticks of those lengths.");
		}
		
	}
}