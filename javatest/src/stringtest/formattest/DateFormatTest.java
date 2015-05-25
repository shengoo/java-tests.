package stringtest.formattest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormatTest test = new DateFormatTest();
		System.out.println(test.validateDate("2014-04-30"));
		System.out.println(test.validateDate("2014.04.30 00:00:00"));
	}
	
	/*
	 * Validate date string with formatter
	 */
	public boolean validateDate(String date_string) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.parse(date_string);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
