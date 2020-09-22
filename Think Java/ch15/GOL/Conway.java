import javax.swing.JFrame;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * Conway's Game of Life.
 */
public class Conway {

    private GridCanvas grid;
	private Console CMD;
	private static Scanner in = new Scanner(System.in);

    /**
     * Creates a grid with two Blinkers.
     */
    public Conway() {
        grid = new GridCanvas(10, 20, 30);
		CMD = new Console(grid);
		CMD.start();
        grid.turnOn(2, 2);
		grid.turnOn(4, 3);
		grid.turnOn(3, 3);
		grid.turnOn(4, 2);
		grid.turnOn(4, 1);
    }
	
	public Conway(String path) {
		File file = new File(path);
		List<String> cells = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		while (scan.hasNextLine()) {
			String temp = scan.nextLine();
			if (temp.charAt(0) != '!') {
				cells.add(temp);
			}
		}
		
		grid = new GridCanvas(cells.size() + 3, cells.get(0).toCharArray().length + 3, 50);
		CMD = new Console(grid);
		CMD.start();
		
		for (int i = 0; i < cells.size(); i++) {
			for (int i1 = 0; i1 < cells.get(i).toCharArray().length; i1++) {
				char cell = cells.get(i).toCharArray()[i1];
				if (cell == 'O') {
					grid.turnOn(i + 1, i1 + 1);
				}
			}
		}
	}

    /**
     * Counts the number of live neighbors around a cell.
     * 
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    private int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);
        return count;
    }

    /**
     * Apply the update rules of Conway's Game of Life.
     * 
     * @param cell the cell to update
     * @param count number of live neighbors
     */
    private static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                // Any live cell with fewer than two live neighbors dies,
                // as if by underpopulation.
                // Any live cell with more than three live neighbors dies,
                // as if by overpopulation.
                cell.turnOff();
            }
        } else {
            if (count == 3) {
                // Any dead cell with exactly three live neighbors
                // becomes a live cell, as if by reproduction.
                cell.turnOn();
            }
        }
    }

    /**
     * Counts the neighbors before changing anything.
     * 
     * @return number of neighbors for each cell
     */
    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }
        return counts;
    }

    /**
     * Updates each cell based on neighbor counts.
     * 
     * @param counts number of neighbors for each cell
     */
    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    /**
     * Simulates one round of Conway's Game of Life.
     */
    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    /**
     * The simulation loop.
     * 
     * @param rate frames per second
     */
    private void mainloop() {
        while (true) {
			try {
                Thread.sleep(CMD.speed);
            } catch (InterruptedException e) {
                // do nothing
            }
			if (CMD.step) {
				CMD.step = false;
			} else if (CMD.pause) {
				continue;
			}

            // update the drawing
            this.update();
            grid.repaint();
        }
    }

    /**
     * Creates and runs the simulation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Conway's Game of Life";
        Conway game = new Conway("glider.cells");
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
    }

}