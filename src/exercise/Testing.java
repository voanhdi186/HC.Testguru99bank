import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class Testing {

	public static void main(String args[]) {
		
//------	#1/ Write a method to generate number of random character. First character must be in capital
		
		String stringPool = "abcdefghijklmnopqrstuvwxyz";
		int lenghtOfString;
		
		// read number from console
		System.out.print("Enter a number: ");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		lenghtOfString = Integer.parseInt(number);
		
		// generate random a string with the length input above
		StringBuilder builder = new StringBuilder();
		while (lenghtOfString-- != 0) {
			int position = (int)(Math.random()*stringPool.length());
			builder.append(stringPool.charAt(position));			
		}
		
		// select then replace the first character with Uppercased one
		String temp = String.valueOf(builder.toString().charAt(0)).toUpperCase();
		builder.replace(0, 1, temp);
		
		System.out.println("Random name: " + builder.toString());
	
		
//------	#2/ Write a method to get day of week from input number of day
		// read number from console
		Calendar cal = Calendar.getInstance();
		System.out.println("Current date: " + cal.getTime());
		System.out.print("Enter a number: ");
		number = scanner.nextLine();
		int addDay;
		addDay = Integer.parseInt(number);
		
		cal.add(Calendar.DATE, addDay);
		System.out.println("Future after " + addDay + " days is " + cal.getTime());
		
		scanner.close();
	}

}