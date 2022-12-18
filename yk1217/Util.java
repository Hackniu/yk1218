package yk1217;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	/* cast the string to date */
	public Date convertStringToDate(String dayStr) throws Throwable {
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
		return f.parse(dayStr);
	}

}
