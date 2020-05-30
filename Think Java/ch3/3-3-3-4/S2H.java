import java.util.Scanner;

public class S2H {
	
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("input seconds: ");
		int inSeconds = in.nextInt();
		int hours = inSeconds / 3600;
		int minutes = (inSeconds % 3600) / 60;
		int outSeconds = (inSeconds % 3600) % 60;
		System.out.printf("Hour:minute:seconds = %d:%d:%d", hours, minutes, outSeconds);
    }
}