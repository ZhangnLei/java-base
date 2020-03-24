package mrzhang.base;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhangnianlei
 * @date 2020/2/27
 */
public class LocalDateUsejava8 {

	public static void main(String[] args) {
		LocalDate begin = LocalDate.parse("2020-03-01");
		LocalDate end = LocalDate.parse("2020-03-12");

		sout(begin, end);
		System.out.println();
//		System.out.println(LocalDateTime.now().toString());
	}

	public static void sout(LocalDate begin, LocalDate end) {
		System.out.println("begin: "+ begin.toString());
		System.out.println("end: "+ end.toString());
		LocalDate now = LocalDate.parse("2020-03-03");
		System.out.println("now: "+ now.toString());
		if (begin.isAfter(now)){
			System.out.println("合法");
		}
		if (now.isBefore(begin)) {
			System.out.println("未生效");;
		}else if (now.isAfter(end)){
			System.out.println("已失效");;
		} else {
			System.out.println("已生效");;
		}
	}
}
