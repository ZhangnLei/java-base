package mrzhang.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhangnianlei
 * @date 2020/5/14
 */
public class OperationTest {
	public static void main(String[] args) {
		boolean needAdd = false; // 是否需要查询父级及子集
		// TODO: 2020/5/14 设置其他查询时也返回树形 - 添加判断条件即可 ||
		if (false || false || false || false || true) {
			needAdd = true;
		}
		System.out.println(needAdd);

	}
}
