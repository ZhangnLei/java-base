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




		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		String localTime = df.format(time);
		System.out.println(localTime);

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
