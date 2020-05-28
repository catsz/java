import java.time.LocalDateTime; // Import the LocalDateTime class


public class Time {

	
    public static void main(String[] args) {
		LocalDateTime time = LocalDateTime.now();
		int seconds = 0;
		float dayPassed = 0;
		int startTime = 0;
		int timePassed = 0;
		
		startTime += 18000;
		startTime += 1500;
		seconds += time.getSecond();
		seconds += (time.getMinute() * 60);
		seconds += (time.getHour() * 3600);
		dayPassed = 100 * seconds / 86400;
		timePassed = seconds - startTime;
		
		System.out.println("time since midnight in seconds " + seconds);
		System.out.println("how much day has passed in percentage " + dayPassed + "%");
		seconds = 86400 - seconds;
		System.out.println("time until the day ends in seconds " + seconds + " seconds");
		System.out.println("I have worked on this for " + timePassed + " seconds");
		
    }
}