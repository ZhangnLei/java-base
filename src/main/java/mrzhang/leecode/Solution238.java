package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangnianlei
 * @date 2020/6/5
 */
public class Solution238 {

	/**
	 * @description
	 * 238. 除自身以外数组的乘积
	 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
	 *
	 * 示例:
	 *
	 * 输入: [1,2,3,4]
	 * 输出: [24,12,8,6]
	 *
	 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
	 *
	 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
	 *
	 * 进阶：
	 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
	 *
	 * 通过次数53,025提交次数75,907
	 *
	 * @author zhangnianlei
	 * @date 2020/6/5
	 * @exception
	 * @modifier
	 */


	public static int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int product = getProduct(nums, i);
			result[i] = product;
			product = 1;
		}
		return result;
	}

	private static int getProduct(int[] nums, int index) {
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			if (i != index) {
				product *= nums[i];
			}
		}
		return product;
	}

	public static int[] productExceptSelf(int[] nums) {
		int length = nums.length;

		// L 和 R 分别表示左右两侧的乘积列表
		int[] L = new int[length];
		int[] R = new int[length];

//		int[] answer = new int[length];

		// L[i] 为索引 i 左侧所有元素的乘积
		// 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
		L[0] = 1;
		for (int i = 1; i < length; i++) {
			L[i] = nums[i - 1] * L[i - 1];
		}

		// R[i] 为索引 i 右侧所有元素的乘积
		// 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
		R[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			R[i] = nums[i + 1] * R[i + 1];
		}

		// 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
		for (int i = 0; i < length; i++) {
			L[i] = L[i] * R[i];
		}

		return L;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4};
//		int[] nums = new int[]{1, 2, 3, 4, 0};
		System.out.println(JSON.toJSONString(productExceptSelf(nums)));
	}
}
