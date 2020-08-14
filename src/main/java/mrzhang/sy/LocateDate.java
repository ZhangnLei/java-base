package mrzhang.sy;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;

/**
 * @author zhangnianlei
 * @date 2020/7/29
 */
public class LocateDate {

	public static void main(String[] args) {
		System.out.println(getTime("2020-07-13 000.0"));
		System.out.println(getTime("2020-07-13"));
		System.out.println(getTime("2020-07-13"));
		System.out.println(getTime("200.0"));
		System.out.println(getTime("2020- 00.0"));
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
