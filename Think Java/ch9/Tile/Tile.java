import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;

public class Tile {
	private char letter;
	private int value;
	
	public Tile(char letter, int value) {
		this.letter = letter;
		this.value = value;
	}
	
	public static void printTile(Tile tile) {
		System.out.printf("letter: %s, value: %02d", tile.getLetter(), tile.getValue());
	}
	
	public char getLetter() {
		return this.letter;
	}
	
	public void setLetter(char set) {
		this.letter = set;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setLetter(int set) {
		this.value = set;
	}
	
	public String toString() {
		return String.format("letter: %s, value: %02d", this.letter, this.value);
	}
	
	public boolean equals(Tile tile) {
		return this.letter == tile.getLetter() && this.value == tile.getValue();
	}
	
	public static void main(String[] args) {
		Tile tile = new Tile('Z', 10);
		Tile.printTile(tile);
	}
}