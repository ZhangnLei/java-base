package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/1/30
 *
 * 4. 寻找两个有序数组的中位数
 */
public class Solution004 {

	/**
	 * 题目描述：
	 *
	 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
	 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	 * 你可以假设 nums1 和 nums2 不会同时为空。
	 *
	 * 示例 1:
	 * nums1 = [1, 3]
	 * nums2 = [2]
	 * 则中位数是 2.0
	 *
	 * 示例 2:
	 * nums1 = [1, 2]
	 * nums2 = [3, 4]
	 * 则中位数是 (2 + 3)/2 = 2.5
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/**
	 * @description 暴力法
	 * 时间复杂度：O(m+n)
	 * 思路：
	 * <p>将两个数组合并成一个数组，然后找出中位数</p>
	 * <p>如何合并：</p>
	 *      <p>创建一个新的数组，两个指针依次移动</p>
	 *      <p>把第二个数组插入到第一个中</p>
	 * <p>如何找：公式</p>
	 *      <p>奇数个：nums[lenght/2]</p>
	 *      <p>偶数个：(nums[((lenght-1)/2] + nums[(lenght+1)/2)/2])/(float)2 </p>
	 * @author zhangnianlei
	 * @date 2020/1/30
	 * @exception
	 * @param: nums1
	 * @param: nums2
	 * @return: double
	 * @modifier
	 */
	public static double findMedianSortedArraysVolice(int[] nums1, int[] nums2) {
		int[] nums = mergeTwoArrays(nums1, nums2);
		return getMedian(nums);
	}

	/**
	 * @description 获取中位数
	 * @author zhangnianlei
	 * @date 2020/1/30
	 * @exception
	 * @param: nums
	 * @return: double
	 * @modifier
	 */
	private static double getMedian(int[] nums) {
		int lenght = nums.length;
		double result = 0;
		if (lenght % 2 == 1){
			result = nums[lenght/2];
		}else {
			result = (nums[(lenght - 1) / 2] + nums[(lenght + 1) / 2]) / (float)2;
		}
		return result;
	}

	/**
	 * @description 合并两个数组
	 * @author zhangnianlei
	 * @date 2020/1/30
	 * @exception
	 * @param: nums1
	 * @param: nums2
	 * @return: int[]
	 * @modifier
	 */
	private static int[] mergeTwoArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		int i = 0 ,j = 0, p=0;
		while(p < nums.length){
			if (i >= nums1.length){
				nums[p] = nums2[j];
				j++;
			} else if (j >= nums2.length){
				nums[p] = nums1[i];
				i++;
			}else {
				if (nums1[i] < nums2[j]){
					nums[p] = nums1[i];
					i++;
				}else {
					nums[p] = nums2[j];
					j++;
				}
			}
			p++;
		}
		return nums;
	}

	/**
	 * @description 优化暴力法
	 * 时间复杂度：O(m+n)/2 = O(m+n)
	 * <p>优化思路：不需要将所有的数字都排好序，只需要找到index = lenght/2</p>
	 * @author zhangnianlei
	 * @date 2020/1/30
	 * @exception
	 * @param: nums1
	 * @param: nums2
	 * @return: double
	 * @modifier
	 */
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

		return 1;
	}


	public static void main(String[] args) {
//		int[] a = {1,2,3,4,5,6};
//		int[] b = {0};
		int[] a = {1,2};
		int[] b = {3,4};
		double result = findMedianSortedArrays(a, b);
		System.out.println(result);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1>n2)
			return findMedianSortedArrays(nums2, nums1);
		int k = (n1 + n2 + 1)/2;
		int left = 0;
		int right = n1;
		while(left < right){
			int m1 = left +(right - left)/2;
			int m2 = k - m1;
			if (nums1[m1] < nums2[m2-1])
				left = m1 + 1;
			else
				right = m1;
		}
		int m1 = left;
		int m2 = k - left;
		int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
				m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
		if ((n1 + n2) % 2 == 1) //奇数
			return c1;
		int c2 = Math.min( m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
				m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
		return (c1 + c2) * 0.5;

	}
//
//	作者：powcai
//	链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/shuang-zhi-zhen-by-powcai/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
