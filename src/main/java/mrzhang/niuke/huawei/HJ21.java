package mrzhang.niuke.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 *
 *
 *
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 *
 *
 *
 * 他是这么变换的，大家都知道手机上的字母：
 * 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
 * 就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 *
 *
 *
 * 声明：密码中没有空格，而密码中出现的
 * 大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 *
 * 输入描述：
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 *
 * 输出描述：
 * 输出渊子真正的密文
 *
 * 示例1
 * 输入：
 * YUANzhi1987
 * 复制
 * 输出：
 * zvbo9441987
 * 复制
 * @date 2021/8/5
 */
public class HJ21 {

	private static Map<Character, Character> map = new HashMap() {{
		put('a', '2');
		put('b', '2');
		put('c', '2');

		put('d', '3');
		put('e', '3');
		put('f', '3');

		put('g', '4');
		put('h', '4');
		put('i', '4');

		put('j', '5');
		put('k', '5');
		put('l', '5');

		put('m', '6');
		put('n', '6');
		put('o', '6');

		put('p', '7');
		put('q', '7');
		put('r', '7');
		put('s', '7');

		put('t', '8');
		put('u', '8');
		put('v', '8');

		put('w', '9');
		put('x', '9');
		put('y', '9');
		put('z', '9');

		put('A', 'b');
		put('B', 'c');
		put('C', 'd');
		put('D', 'e');
		put('E', 'f');
		put('F', 'g');
		put('G', 'h');
		put('H', 'i');
		put('I', 'j');
		put('J', 'k');
		put('K', 'l');
		put('L', 'm');
		put('M', 'n');
		put('N', 'o');
		put('O', 'p');
		put('P', 'q');
		put('Q', 'r');
		put('R', 's');
		put('S', 't');
		put('T', 'u');
		put('U', 'v');
		put('V', 'w');
		put('W', 'x');
		put('X', 'y');
		put('Y', 'z');
		put('Z', 'a');
	}};


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String password = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < password.length(); i++) {
				Character replaceWord = map.get(password.charAt(i));
				if (null == replaceWord) {
					sb.append(password.charAt(i));
				} else {
					sb.append(replaceWord);
				}
			}
			System.out.println(sb.toString());

		}
	}

}
