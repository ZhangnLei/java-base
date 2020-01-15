package mrzhang.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/1/15
 */
public class StringJoin {
	public static void main(String[] args) {
		List<String> language = new ArrayList<>(8);
		language.add("java");
		language.add("php");
		language.add("c++");
		System.out.println(String.join(";", language));
	}
}
