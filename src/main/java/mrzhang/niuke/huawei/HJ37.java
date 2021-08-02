package mrzhang.niuke.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ37 {

	private static Map<Integer, Integer> feiMap = new HashMap<>();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int m = sc.nextInt();
			System.out.println(fei(m));
		}
	}


	private static int fei(int m) {
		if (m == 0) return 0;
		if (m == 1) return 1;
		if (m == 2) return 1;
		Integer result = feiMap.get(m);
		if (result == null) {
			result = fei(m - 2) + fei(m - 1);
		}
		feiMap.put(m, result);
		return result;

	}

}
