package mrzhang.leecode;

import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/9/10
 */


//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 375 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution40 {

	/**
	 * 我的思路1： 
	 * 使用递归暴力破解
	 * 递归的target = target - num[i] 
	 * 递归的区间为[i+1, num.length -1]
	 * 
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

