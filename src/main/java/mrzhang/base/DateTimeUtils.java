package mrzhang.base;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangnianlei
 * @date 2020/1/9
 */
public class DateTimeUtils {
//	public static void main(String[] args) {
//		Object newSqlDate = new java.sql.Date(new java.util.Date().getTime());
//		System.out.println("sqlDateToString***"+newSqlDate.toString());
//	}

	public static void main(String[] args) throws Exception {
		String data = "2019";
		System.out.println(getDatePart(data));
	}

	public static String getDatePart1(String string) {
		LocalDateTime dateTime = LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return dateTime.toLocalDate().toString();
	}

	public static String getDatePart(String string) throws Exception {
		String[] s = string.split(" ");
		if (string.length() < 1) {
			throw new Exception("日期转换失败");
		}
		return s[0];
	}

}
