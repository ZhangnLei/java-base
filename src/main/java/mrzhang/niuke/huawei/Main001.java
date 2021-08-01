package mrzhang.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangnianlei
 * @description 空瓶换汽水问题（递归）
 * @date 2021/7/31
 */
public class Main001 {

	public static void main(String[] args) throws IOException {
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str=bu.readLine())!=null){
			//终止模块
			if(str.equals("0")) break;
			Integer count = count(Integer.valueOf(str));
			System.out.println(count);
		}
	}


	public static Integer count(Integer n) {
		Integer result = 0;
		if (n == 1) return 0;
		if (n == 2) return 1;
		result += n / 3;

		int mod = n % 3;
		return result + count(result + mod);
	}

}
