package mrzhang.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangnianlei
 * @description 汽水瓶换汽水
 * @date 2021/8/1
 */
public class Main00102 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = bufferedReader.readLine()) != null) {
			if ("0".equals(str)) break;
			System.out.println(Integer.valueOf(str) / 2);
		}
	}
}
