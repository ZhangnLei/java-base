package mrzhang.niuke.testhuawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @author zhangnianlei
 * @description 多组数据去重、排序
 * @date 2021/8/1
 */
public class Main003 {


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str;

		TreeSet<Integer> nums = new TreeSet<>();
		while ((str = bufferedReader.readLine()) != null) {
			Integer count = Integer.valueOf(str);
			for (int i = 0; i< count; i++) {
				nums.add(Integer.valueOf(bufferedReader.readLine()));
			}
			nums.forEach(System.out::println);
			nums = new TreeSet<>();
		}
	}
}
