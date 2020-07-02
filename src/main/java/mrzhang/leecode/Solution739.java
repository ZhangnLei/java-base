package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangnianlei
 * @date 2020/6/11
 */
public class Solution739 {


	/**
	 * @description 739. 每日温度
	 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
	 *
	 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
	 *
	 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
	 * @author zhangnianlei
	 * @date 2020/6/11
	 * @exception
	 * @modifier
	 *
	 * 思路一： 两个for循环；
	 * 第一个for循环保存数字 nums[i] i 的区间为[0， nums.length-1]
	 * 第二个for循环的遍历后面的数字nums[J] j的区间为 [i, nums.length-1]
	 *  切当nums[j] > nums[i]时结束循环，更新nums[i]的值 nums[i] = j-i;
	 *  当直到最后都没有大于的数时，设置nums[i] = 0;
	 */
	public static int[] dailyTemperatures(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			boolean has = false;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					nums[i] = j-i;
					has = true;
					break;
				}
			}
			if (!has) {
				nums[i] = 0;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums =new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(JSON.toJSONString(dailyTemperatures(nums)));
	}

}
