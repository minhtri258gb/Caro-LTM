package ltm.caro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


public class DateTimeUtil {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


	public static String covDateToString(Date d) {
		if (d == null)
			d = new Date();
		return dateFormat.format(d);
	}

	public static Date covStringToDate(String s) {
		if (s == null || s.isEmpty())
			return null;
		try {
			return dateFormat.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String covDateTimeToString(Date d) {
		if (d == null)
			d = new Date();
		return datetimeFormat.format(d);
	}

	public static Date covStringToDateTime(String s) {
		if (s == null || s.isEmpty())
			return null;
		try {
			return datetimeFormat.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	public static LocalTime covDateToLocalTime(Date starttimeDat) {
		return starttimeDat.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalTime();
	}

}
