package mrzhang.sy;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangnianlei
 * @date 2020/7/29
 */
public class LocateDate {

	private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
//		System.out.println(getTime("2020-07-13 000.0"));
//		System.out.println(getTime("2020-07-13"));
//		System.out.println(getTime("2020-07-13"));
//		System.out.println(getTime("200.0"));
//		System.out.println(getTime("2020- 00.0"));
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////		System.out.println(LocalDateTime.now().toString());


//		LocalDateTime time = LocalDateTime.now();
//		String localTime = df.format(time);
//		LocalDateTime ldt = LocalDateTime.parse("2017-09-28 17:07:05",df);
//		ldt.
//		System.out.println("LocalDateTime转成String类型的时间："+localTime);
//		System.out.println("String类型的时间转成LocalDateTime："+ldt);

//		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		LocalDateTime time = LocalDateTime.now();
//		String localTime = df.format(time);
//		System.out.println(localTime);
//
//
//
//		LocalDateTime ldt = LocalDateTime.parse("2017-09-28 17:07:05",df);
//		System.out.println("String类型的时间转成LocalDateTime："+ldt);


		LocalDateTime startDateTime = LocalDateTime.parse("2019-12-31 23:53:45", df);
		LocalDateTime dayStart = getDayAddSecond(startDateTime);
		System.out.println(df.format(dayStart));
	}


	//获取一天的开始时间，2017,7,22 00:00
	public static LocalDateTime getDayStart(LocalDateTime time) {
		return time.withHour(0)
				.withMinute(0)
				.withSecond(0)
				.withNano(0);
	}

	// LocalDateTime 添加一秒
	public static LocalDateTime getDayAddSecond(LocalDateTime time) {
		int second = time.getSecond() + 1;
		int minute = time.getMinute();
		int hour = time.getHour();
		int days = time.getDayOfYear();
		int year = time.getYear();
		if (second >= 60) {
			second = 0;
			minute += 1;
		}
		if (minute >= 60) {
			minute = 0;
			hour += 1;
		}
		if (hour >= 24) {
			hour = 0;
			days += 1;
		}
		if (days > 365) {
			days = 1;
			year += 1;
		}
		return time.withYear(year)
				.withDayOfYear(days)
				.withHour(hour)
				.withMinute(minute)
				.withSecond(second)
				.withNano(0);
	}

	private static LocalDate getTime(String string) {
		if (StringUtils.isBlank(string)) {
			return null;
		}
		String[] list = string.split(" ");
		try {
			if (list != null && list.length == 2) {
				return LocalDate.parse(list[0]);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
