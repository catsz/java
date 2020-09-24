import java.util.Scanner;
import java.util.NoSuchElementException;

public class Console extends Thread {
	private GridCanvas grid;
	public boolean pause = true;
	public boolean step = false;
	public int speed = 350;
	
	public Console(GridCanvas grid) {
		this.grid = grid;
	}
	
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while (true) {
			String cmd1 = "";
			String[] cmd = new String[0];
			try {
				cmd1 = in.nextLine();
				cmd = cmd1.split(" ");
			} catch (Exception ex) {
				continue;
			}
			if (cmd[0].equals("population")) {
				System.out.println("Population: " + grid.countOn());
			} else if (cmd[0].equals("pause")) {
				pause = !pause;
			} else if (cmd[0].equals("step")) {
				step = true;
			} else if (cmd[0].equals("speed")) {
				try {
						speed = 350 / Integer.parseInt(cmd[1]);
						System.out.println("Speed set to: " + speed);
				} catch (NumberFormatException ex) {
					System.out.println("Please input an actual number.");
				}
			} else {
				System.out.println(cmd[0] + " is not recognized as a command.");
			}
		}
	}
	
}