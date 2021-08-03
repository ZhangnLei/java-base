package mrzhang.niuke.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ73 {

	private static Map<Integer, Integer> daysMap = new HashMap<>(12);

	static {
		daysMap.put(1, 0);
		daysMap.put(2, 31);
		daysMap.put(3, 60 - 1); // 2月按照28日算，if (闰年 &&月份大于2) 则+1
		daysMap.put(4, 91 - 1);
		daysMap.put(5, 121 - 1);
		daysMap.put(6, 152 - 1);
		daysMap.put(7, 182 - 1);
		daysMap.put(8, 213 - 1);
		daysMap.put(9, 244 - 1);
		daysMap.put(10, 274 - 1);
		daysMap.put(11, 305 - 1);
		daysMap.put(12, 335 - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			int year = Integer.valueOf(s[0]);
			int mon = Integer.valueOf(s[1]);
			int day = Integer.valueOf(s[2]);

			/*
			判定公历闰年遵循的规律为: 四年一闰,百年不闰,四百年再闰.
			公历闰年的简单计算方法:（符合以下条件之一的年份即为闰年）
			1。能被4整除而不能被100整除。（如2004年就是闰年,1900年不是）
			2。能被400整除。（如2000年是闰年）
			 */
			boolean specialYear = false;
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				specialYear = true;
			}

			int total = daysMap.get(mon) + day;

			total = (specialYear && mon > 2) ? total + 1 : total;
			System.out.println(total);

		}
	}

}
