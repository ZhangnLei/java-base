package mrzhang.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ14 {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			Integer num = Integer.valueOf(sc.nextLine());
			List<String> strList = new ArrayList<>(num);
			for (int i = 0; i < num; i++) {
				String line = sc.nextLine();
				strList.add(line);
			}
			strList.stream().sorted((a, b) -> {
				return a.compareTo(b);
			}).collect(Collectors.toList()).forEach(System.out::println);
		}
	}


	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (sc.hasNextLine()) {
			Integer size = Integer.valueOf(sc.nextLine());
			String[] strings = new String[size];
			for (int i = 0; i < size; i++) {
				strings[i] = sc.nextLine();
			}
			Arrays.sort(strings);
			for (String s : strings) {
				System.out.println(s);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer size = Integer.valueOf(br.readLine());
		String[] strings = new String[size];
		for (int i = 0; i < size; i++) {
			strings[i] = br.readLine();
		}
		Arrays.sort(strings);

		for (String s : strings) {
			System.out.println(s);
		}
	}
}
