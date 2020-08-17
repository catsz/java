

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date() {
		this.year = 0000;
		this.month = 01;
		this.day = 1;
	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public static void main(String[] args) {
		Date birthday = new Date(2007, 1, 22);
	}
}