package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangnianlei
 * @date 2020/7/20
 *
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class Solution167 {

	/**
	 * @description  `思路1：暴力法`
	 * 两个for循环嵌套，当target - num[i] == num[j]时推出for循环，返回 res[] = [i+1, j+1]
	 */
	public static int[] twoSum1(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (target - numbers[i] == numbers[j]) {
					return new int[]{i+1, j+1};
				}
			}
		}
		return new int[2];
	}

	/**
	 * @description  `思路2：二分查找法`
	 * 利用*升序数组*这一条件，固定一个值i，然后去数组里查找j，应为数组是升序的，查找时可使用二分查找法。
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		int res[] = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int index2 = getIndexBetween(numbers, i + 1, numbers.length -1, target - numbers[i]);
			if (index2 > -1) {
				return new int[]{i+1, index2 + 1};
			}
		}
		return res;
	}

	/**
	 * @description 二分法查找元素
	 * 查找区间为 (begin, nums.length-1]
	 */
	private static int getIndexBetween(int[] nums, int begin, int end, int target) {
		int mid = (begin + end) / 2;
		if (begin > end) return -1;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return getIndexBetween(nums, begin, mid -1, target);
		} else {
			return getIndexBetween(nums, mid + 1, end, target);
		}
	}

	/**
	 * @description  `思路3：双指针法`
	 * 两个指针分别指向头和尾，当两数之和等于target时，返回结果；两数之和大于target时，尾指针前移；两数之和小于target时，首指针后移。移动后再次判断，直至找到唯一解。
	 */
	public static int[] twoSum3(int[] numbers, int target) {
		int res[] = new int[2];
		int left = 0, right = numbers.length -1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				return new int[]{left + 1, right + 1};
			} else if (sum < target) {
				left += 1;
			} else {
				right -= 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int nums1[] = new int[]{1, 2, 7, 11, 15};
		int target1 = 9;
		System.out.println(JSON.toJSONString(nums1));
		System.out.println(JSON.toJSONString(twoSum1(nums1, target1)));
		System.out.println(JSON.toJSONString(twoSum2(nums1, target1)));
		System.out.println(JSON.toJSONString(twoSum3(nums1, target1)));

		System.out.println();
		int nums2[] = new int[]{1, 2, 4, 4, 6, 11, 15};
		int target2 = 8;
		System.out.println(JSON.toJSONString(nums2));
		System.out.println(JSON.toJSONString(twoSum1(nums2, target2)));
		System.out.println(JSON.toJSONString(twoSum2(nums2, target2)));
		System.out.println(JSON.toJSONString(twoSum3(nums2, target2)));
		System.out.println();

		int nums3[] = new int[]{1, 2};
		int target3 = 3;
		System.out.println(JSON.toJSONString(nums3));
		System.out.println(JSON.toJSONString(twoSum1(nums3, target3)));
		System.out.println(JSON.toJSONString(twoSum2(nums3, target3)));
		System.out.println(JSON.toJSONString(twoSum3(nums3, target3)));

		System.out.println();

		int nums4[] = new int[]{1,2,3,4,4,9,56,90};
		int target4 = 8;
		System.out.println(JSON.toJSONString(nums4));
		System.out.println(JSON.toJSONString(twoSum1(nums4, target4)));
		System.out.println(JSON.toJSONString(twoSum2(nums4, target4)));
		System.out.println(JSON.toJSONString(twoSum3(nums4, target4)));

	}
}
