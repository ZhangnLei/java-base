package mrzhang.leecode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangnianlei
 * @date 2020/3/9
 *     str = str.lstrip()      #清除左边多余的空格
 *         num_re = re.compile(r'^[\+\-]?\d+')   #设置正则规则
 *         num = num_re.findall(str)   #查找匹配的内容
 *         num = int(*num) #由于返回的是个列表，解包并且转换成整数
 *         return max(min(num,INT_MAX),INT_MIN)    #返回值
 */
public class Solution008 {

	public static int myAtoi(String str) {
		str = str.trim();
		// 定义正则
		String pattern = "r'^[\\+\\-]?\\d+'";
		Pattern r = Pattern.compile(pattern);
		Matcher matcher = r.matcher(str);
//		if (matcher) {

//		}
		return 1;
	}


	public static void main(String[] args) {
		System.out.println(myAtoi("zhang"));
	}
}
