import javax.swing.JFrame;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;

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
		String[] ext = path.split("\\.");
		File file = new File(path);
		List<String> cells = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		try {
				scan = new Scanner(file);
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		//see if it's .rle or .cells
		if (ext[1].equals("rle")) {
			
			while (scan.hasNextLine()) {
				String temp = scan.nextLine();
				if (temp.charAt(0) != '#') {
					cells.add(temp);
				}
			}
			String[] size = cells.get(0).split(",");
			int x = -1;
			int y = -1;
			
			for (int i = 0; i < size.length; i++) {
				char[] SChars = size[i].toCharArray();
				String temp = "";
				
				for (int i1 = 4; i1 < SChars.length; i1++) {
					temp = temp + SChars[i1];
				}
				if (x != -1) {
					y = Integer.parseInt(temp.split(" ")[1]);
				} else {
					x = Integer.parseInt(temp);
				}
			}
			
			grid = new GridCanvas(y + 3, x + 3, 50);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/////////////////////////////////////////////////////////////////////////////////
			
			int col = 0;
			int row = 0;
			int numStart = -1;
			int n = 1;
			for (int i = 1; i < cells.size(); i++) {
				String line = cells.get(i);
				char[] rleChar = line.toCharArray();
				System.out.println("line = " + line);
				System.out.println("char array length = " + rleChar.length);
				
				int i1 = 0;
				while((i1 < rleChar.length) && (rleChar[i1] != '!')) {

					// $ = move to next row
					if(rleChar[i1] == '$') {
						row++;
						numStart = -1;
						col = 0;
					} else if (rleChar[i1] >= '0' && rleChar[i1] <= '9') {
						numStart = i1;
					} else if (rleChar[i1] == 'b') {
						if(numStart == -1) {
							n = 1;
						} else {
							n = Integer.parseInt(line.substring(numStart, i1));
						}
						
						col += n;
						
						numStart = -1;
					} else if (rleChar[i1] == 'o') {
						if(numStart == -1) {
							n = 1;
						} else {
							n = Integer.parseInt(line.substring(numStart, i1));
						}
						
						for(int i2 = 0; i2 < n; i2++) {
						  grid.turnOn(row, col+i2);
						}
						
						numStart = -1;
					}
					
					i1++;

				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/////////////////////////////////////////////////////////////////////////////////
			/*
			boolean KG = true;
			for (int i = 1; i < cells.size() && KG; i++) {
				String[] line = cells.get(i).split("$");
				
				for (int i1 = 0; i1 < line.length && KG; i1++) {
					char[] cell = line[i1].toCharArray();
					int col = 0;
					int n = 1;
					
					for (int i2 = 0; i2 < cell.length; i2++) {
						if (cell[i2] == '!') {
							KG = false;
							break;
						}
						System.out.println(cell[i2]);
						try {
							n = Integer.parseInt(String.valueOf(cell[i2]));
							System.out.println(cell[i2]);
							System.out.println(n);
						} catch (Exception ex) {
							for (int i3 = 0; i3 < n; i3++) {
								System.out.println("in loop");
								if (cell[i2] == 'b') {
									
								} else if (cell[i2] == 'o') {
									grid.turnOn(i1, col);
								} else if (cell[i2] == '$') {
									break;
								}
								col++;
							}
						}
					}
				}	
			}
			*/
		} else {
			
			//for every line that doesn't start with ! add it to the list
			while (scan.hasNextLine()) {
				String temp = scan.nextLine();
				if (temp.charAt(0) != '!') {
					cells.add(temp);
				}
			}
			
			//make the canvas
			grid = new GridCanvas(cells.size() + 3, cells.get(0).toCharArray().length + 3, 50);
			
			//first loop to go through the list
			for (int i = 0; i < cells.size(); i++) {
				//second loop to loop through all the characters in the strings
				for (int i1 = 0; i1 < cells.get(i).toCharArray().length; i1++) {
					//get the character that the two loops are on
					char cell = cells.get(i).toCharArray()[i1];
					
					//see if it is a active cell or not
					if (cell == 'O') {
						//if so turn it on
						grid.turnOn(i + 1, i1 + 1);
					}
				}
			}
		}
		CMD = new Console(grid);
		CMD.start();
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
        Conway game = new Conway("glider.rle");
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
    }

}