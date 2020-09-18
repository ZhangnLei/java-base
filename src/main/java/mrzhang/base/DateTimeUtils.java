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

	public static void main(String[] args) {
		String data = "2019-12-05 15:30:11";
		System.out.println(getDatePart(data));
	}

	public static String getDatePart(String string) {
		LocalDateTime dateTime = LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return dateTime.toLocalDate().toString();
	}

}
