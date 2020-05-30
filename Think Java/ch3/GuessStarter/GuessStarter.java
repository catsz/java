import java.util.Random;
import java.util.Scanner;


public class GuessStarter {

    public static void main(String[] args) {
        // pick a random number
        Random random = new Random();
		Scanner in = new Scanner(System.in);
        int rNumber = random.nextInt(100) + 1;
		
		System.out.println("I'm thinking of a number between 1 and 100.");
		System.out.println("Can you guess what it is?");
		System.out.print("What is your guess?: ");
		int guess = in.nextInt();
        System.out.printf("My number was %d you were off by %d", rNumber, Math.max(rNumber, guess) - Math.min(rNumber, guess));
    }
}