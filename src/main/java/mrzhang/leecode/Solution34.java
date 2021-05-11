package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangnianlei
 * @date 2020/12/1
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Solution34 {

	/**
	 * @description 常规思路 遍历
	 * @author zhangnianlei
	 * @date 2020/12/1
	 * @exception
	 * @param: nums
	 * @param: target
	 * @return: int[]
	 * @modifier
	 */
	public static int[] searchRange(int[] nums, int target) {
		int p = -1;
		int q = -1;
		int i = 0;
		while (i < nums.length) {
			if (p != -1 && q != -1) {
				return new int[]{p, q};
			}
			if (nums[i] == target && (i == 0 || nums[i-1] < target)) {
				p = i;
			}
			if (nums[i] == target && (i + 1 == nums.length || nums[i+1] > target)) {
				q = i;
			}
			i++;
		}
		return new int[]{p, q};
	}

	/**
	 * 二分法 （需要特殊处理）
	 * @param args
	 */

	public static void main(String[] args) {
		int[] nums = new int[]{5,7,7,8,8,10};
		int[] range = searchRange(nums, 8);
		System.out.println(JSON.toJSONString(range));
	}
}
