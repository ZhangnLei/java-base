package mrzhang.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ58 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			Integer n = Integer.valueOf(line[0]);
			Integer k = Integer.valueOf(line[1]);
			int[] nums = new int[n];
			String[] s = sc.nextLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.valueOf(s[i]);
			}
			Arrays.sort(nums);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k; i++) {
				sb.append(nums[i]).append(" ");
			}
			System.out.println(sb.toString());

		}

	}

}
