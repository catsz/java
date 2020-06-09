import java.util.Random;
import java.util.Scanner;


public class GuessStarter {

    public static void main(String[] args) {
        // pick a random number
		Random random = new Random();
		Scanner in = new Scanner(System.in);
		int rNumber = random.nextInt(100) + 1;
		boolean guessR = false;
		int Pguess = 0;
		
		System.out.println("I'm thinking of a number between 1 and 100.");
		System.out.println("Can you guess what it is?");
		System.out.print("What is your guess?: ");
		
		for (int i = 0; i < 3; i++) {
			
			if (i >= 1) {
				System.out.print("What is your new guess?: ");
			}
			
			int guess = in.nextInt();
			
			if (guess == rNumber) {
				System.out.println("You guessed the number!");
				guessR = false;
				break;
			} else {
				guessR = true;
				Pguess = guess;
			}
			
			if (guess > rNumber) {
				System.out.println("Your number is too high.");
			} else if (guess < rNumber) {
				System.out.println("Your number is too low.");
			}
		}
		
		if (guessR) {
			System.out.printf("My number was %d you were off by %d", rNumber, Math.max(rNumber, Pguess) - Math.min(rNumber, Pguess));
		}
    }
}