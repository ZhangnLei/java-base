package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/6/9
 */
public class Solution39 {


	/**
	 * @description 39. 组合总和
	 *
	 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 *
	 * candidates 中的数字可以无限制重复被选取。
	 *
	 * 说明：
	 *
	 * 所有数字（包括 target）都是正整数。
	 * 解集不能包含重复的组合。
	 * 示例 1:
	 *
	 * 输入: candidates = [2,3,6,7], target = 7,
	 * 所求解集为:
	 * [
	 *   [7],
	 *   [2,2,3]
	 * ]
	 * 示例 2:
	 *
	 * 输入: candidates = [2,3,5], target = 8,
	 * 所求解集为:
	 * [
	 *   [2,2,2,2],
	 *   [2,3,3],
	 *   [3,5]
	 * ]
	 * 通过次数98,749提交次数143,196
	 *
	 * @author zhangnianlei
	 * @date 2020/6/9
	 * @exception
	 * @modifier
	 */

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();

		return result;
	}


	public static void main(String[] args) {
		int[] nums = new int[] {2, 3,6,7};
		System.out.println(JSON.toJSONString(combinationSum(nums, 7)));
	}
}
