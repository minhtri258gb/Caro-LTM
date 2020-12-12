package ltm.caro.client;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateField {

	public static boolean account(String s) {
		final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,16}$";
		return s.matches(USERNAME_PATTERN);
	}

	public static boolean email(String s) {
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(s);
		return matcher.find();
	}

	public static boolean birthday(Date d) { // Kiem tra > 1950 < nay - 5 nam
		if (d == null ||
			d.before(new GregorianCalendar(1950, Calendar.JANUARY, 1).getTime()) ||
			d.after(new Date()))
			return false;

		return true;
	}

	public static boolean password(String p, String rp) {
		if (p.length() < 6 || !p.equals(rp))
			return false;
		return true;
	}

}
