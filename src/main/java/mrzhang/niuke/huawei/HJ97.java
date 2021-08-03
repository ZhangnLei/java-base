package mrzhang.niuke.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ97 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int res1 = 0;
			double sum = 0;
			int number = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] < 0) {
					res1 +=1;
				} else if (nums[i] > 0) {
					sum += nums[i];
					number ++;
				}
			}

			double res2 = Math.round(sum * 10.0 / number) / 10.0;
			System.out.println(res1 + " " + res2);
		}
	}

}
