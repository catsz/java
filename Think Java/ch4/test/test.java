import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
	
	public static String printAmerican() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter american = DateTimeFormatter.ofPattern("E, MM, dd, yyyy");
		String AFormatted = time.format(american);
		
		System.out.println("American format: " + AFormatted);
		
		return AFormatted;
	}
	
	public static String printEuropean() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter european = DateTimeFormatter.ofPattern("E dd MM yyyy");
		String EFormatted = time.format(european);
		
		System.out.println("European format: " + EFormatted);
		
		return EFormatted;
	}
	
    public static void main(String[] args) {
		
		printEuropean();
		printAmerican();
		System.out.println("boo!") + 7;
    }
}