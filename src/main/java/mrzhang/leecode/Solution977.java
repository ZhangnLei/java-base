package mrzhang.leecode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangnianlei
 * @date 2020/10/16
 *
 * 977. 有序数组的平方
 * 难度
 * 简单
 *
 * 150
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 */
public class Solution977 {

	public static void main(String[] args) {
		int a[] = {3, 5, 1, 2, 3};
		sortedSquares(a);
	}
	public static int[] sortedSquares(int[] A) {
		TreeSet<Integer> set = new TreeSet();
		for (int i : A) {
			set.add(i * i);
		}
		System.out.println(set.toString());
		return SetToInt(set);
	}

	// 将set集合转为整型int数组的方法
	private static int[] SetToInt(Set<Integer> allSet) {
		// 先将set集合转为Integer型数组
		Integer[] temp = allSet.toArray(new Integer[] {});//关键语句

		// 再将Integer型数组转为int型数组
		int[] intArray = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			intArray[i] = temp[i].intValue();
		}
		return intArray;
	}
}
