import java.util.Scanner;

public class C2F {
	
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("input temperature in celsius: ");
		float celsius = in.nextFloat();
		System.out.printf("temperature in fahrenheit: %.1f\n", (celsius * 9/5) + 32);
    }
}