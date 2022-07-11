package proyecto;

import java.time.LocalDate;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		Calendar date1 = Calendar.getInstance();
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(year);
		
		int month = Calendar.getInstance().get(Calendar.MONTH);
		System.out.println(month);
		
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
	}

}
