package mrzhang.base;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/5/14
 */
public class MergeStringArrays {


	public static void main(String[] args) {
		String[] headers = new String[] {
				"a",
				"b"
		};
		String[] others = new String[]{
				"*业务场景名称"
				, "*服务入口"
				, "*业务场景类型"
				, "*变更类型"
		};
		headers = mergeStringArray(headers, others);

		System.out.println(headers.toString());
		System.out.println(JSON.toJSONString(headers));

	}

	private static String[] mergeStringArray(String[] str1, String[] str2) {
		int strLen1 = str1.length;// 保存第一个数组长度
		int strLen2 = str2.length;// 保存第二个数组长度
		str1 = Arrays.copyOf(str1, strLen1 + strLen2);// 扩容
		System.arraycopy(str2, 0, str1, strLen1, strLen2);// 将第二个数组与第一个数组合并
		return str1;
	}
}
