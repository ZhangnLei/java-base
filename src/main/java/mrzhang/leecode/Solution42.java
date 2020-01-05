package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/1/5
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 三种解法：
 * 暴力法 解决问题，简单粗暴
 * 备忘录优化法 降低时间复杂度
 * 双指针法 降低空间复杂度
 */
public class Solution42 {

	/**
	 * @description 暴力法
	 * @author zhangnianlei
	 * @date 2020/1/5
	 * @exception
	 * @param: height
	 * @return: int
	 * @modifier
	 */
	static int trapViolence(int[] height) {

		int sum = 0;
		int length = height.length;
		for (int i = 1; i < length - 1; i++) {
			int leftMax = getMax(height, 0, i-1);
			int rightMax = getMax(height, i, length-1);
			int heigthDiff = Math.min(leftMax, rightMax) - height[i];
			if (heigthDiff > 0){
				sum += heigthDiff;
			}
		}
		return sum;
	}

	private static int getMax(int[] height, int l, int r) {
		int max = 0;
		for (int i = l; i <= r; i++) {
			max = Math.max(height[i], max);
		}
		return max;
	}

	/**
	 * @description 备忘录法优化
	 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户内存消耗 :37.2 MB, 在所有 Java 提交中击败了84.69%的用户
	 * @author zhangnianlei
	 * @date 2020/1/5
	 * @exception
	 * @param: height
	 * @return: int
	 * @modifier
	 */
	static int trapMemo(int[] height){
		int length = height.length;
		int[] leftMax = new int[length];
		int[] rightMax = new int[length];
		int max = 0;
		for (int i = 1; i < length - 1; i++) {
			leftMax[i] = Math.max(max, height[i-1]);
			max = leftMax[i];
		}
		max = 0;
		for (int i = length - 1; i > 0; i--) {
			rightMax[i] = Math.max(max, height[i]);
			max = rightMax[i];
		}
		int sum = 0;
		for (int i = 1; i < length-1; i++) {
			int heightDifference = Math.min(leftMax[i], rightMax[i]) - height[i];
			if (heightDifference > 0){
				sum += heightDifference;
			}
		}
		return sum;
	}

	/**
	 * @description 双指针法
	 * 执行用时 :2 ms, 在所有 Java 提交中击败了50.58%的用户内存消耗 :36.2 MB, 在所有 Java 提交中击败了92.20%的用户
	 * @author zhangnianlei
	 * @date 2020/1/5
	 * @exception
	 * @param: height
	 * @return: int
	 * @modifier
	 */
	static int trapPoint(int[] height){
		int sum = 0;
		int length = height.length;
		if (length == 0) return 0;
		int left = 0;
		int right = length - 1;
		int leftMax = height[left];
		int rightMax = height[right];
		int heightDiff = 0;
		while (left < right){
			if (leftMax < rightMax){
				heightDiff = Math.min(leftMax, rightMax) - height[left];
				left ++;
				leftMax = Math.max(leftMax, height[left]);
			}else {
				heightDiff = Math.min(leftMax, rightMax) - height[right];
				right --;
				rightMax = Math.max(rightMax, height[right]);
			}
			if (heightDiff > 0){
				sum += heightDiff;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] example = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//		System.out.println(trapViolence(example));
//		System.out.println(trapMemo(example));
		System.out.println(trapPoint(example));
	}
}
