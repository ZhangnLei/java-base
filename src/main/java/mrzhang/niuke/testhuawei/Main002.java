package mrzhang.niuke.testhuawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/1
 */
public class Main002 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = bufferedReader.readLine()) != null) {
			long l = Long.parseLong(str.replace("0x", ""), 16);
			System.out.println(l);
		}
	}

}
