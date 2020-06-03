import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class date {
	
	public static void printAmerican() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter american = DateTimeFormatter.ofPattern("E, MM, dd, yyyy");
		String AFormatted = time.format(american);
		
		System.out.println("American format: " + AFormatted);
	}
	
	public static void printEuropean() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter european = DateTimeFormatter.ofPattern("E dd MM yyyy");
		String EFormatted = time.format(european);
		
		System.out.println("European format: " + EFormatted);
	}
	
    public static void main(String[] args) {
		
		printEuropean();
		printAmerican();
    }
}