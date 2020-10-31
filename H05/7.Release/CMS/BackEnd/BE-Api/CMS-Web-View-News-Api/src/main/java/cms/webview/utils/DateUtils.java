package cms.webview.utils;

import java.text.SimpleDateFormat;

public class DateUtils {

	public static boolean isValid(String dateTime) {
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			java.util.Date date = simpleDateFormat.parse(dateTime);

			if (date.getTime() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
