import java.util.Scanner;
import java.util.NoSuchElementException;

public class Console extends Thread {
	private GridCanvas grid;
	public boolean pause = false;
	public boolean step = false;
	
	public Console(GridCanvas grid) {
		this.grid = grid;
	}
	
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while (true) {
			String cmd = "";
			try {
				cmd = in.next();
			} catch (NoSuchElementException ex) {
				
			}
			if (cmd.equals("population")) {
				System.out.println("Population: " + grid.countOn());
			} else if (cmd.equals("pause")) {
				pause = !pause;
			} else if (cmd.equals("step")) {
				step = true;
			}
		}
	}
	
}