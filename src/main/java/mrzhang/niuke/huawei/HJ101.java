package mrzhang.niuke.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 *
 * 本题有多组输入，请使用while(cin>>)处理
 *
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 *
 * 示例1
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 5
 * 1 2 3 4 5
 * 1
 * 复制
 * 输出：
 * 1 2 3 4 9 25 55 64
 * 5 4 3 2 1
 *
 * @date 2021/8/5
 */
public class HJ101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int size = Integer.parseInt(sc.nextLine());
			long[] list = new long[size];
			String[] nums = sc.nextLine().split(" ");

			for (int i = 0; i < nums.length; i++) {
				list[i] = Long.parseLong(nums[i]);
			}
			int order = Integer.parseInt(sc.nextLine());

			Arrays.sort(list);
			StringBuilder sb = new StringBuilder();
			if (0 == order) {
				for (int i = 0; i < list.length; i++) {
					sb.append(list[i]).append(" ");
				}
			} else {
				for (int i = list.length - 1; i >= 0; i--) {
					sb.append(list[i]).append(" ");
				}
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
	}

}
