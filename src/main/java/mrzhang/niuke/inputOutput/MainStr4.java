package mrzhang.niuke.inputOutput;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 输入描述:
 * 输入有多组测试用例，每组空格隔开两个整数
 * 输出描述:
 * 对于每组数据输出一行两个整数的和
 * @date 2021/8/2
 */
public class MainStr4 {


//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		while (scanner.hasNextLine()) {
//			String[] s = scanner.nextLine().split(" ");
//			System.out.println(s[0] + s[1]);
//		}
//	}

	public static void main1 (String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			Long a = scanner.nextLong();
			Long b = scanner.nextLong();
			System.out.println(a + b);
		}
	}

	public static void main(String[] ag){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Long a = sc.nextLong();
			Long b = sc.nextLong();
			System.out.println(a+b);
		}
	}

}
