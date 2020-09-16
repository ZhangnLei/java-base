package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/9/14
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution94 {

	/**
	 * 递归的方式
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		add2List(result, root);
		return result;
	}

	private void add2List(List<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}
		add2List(result, root.left);
		result.add(root.val);
		add2List(result, root.right);
	}


	/**
	 * @description 迭代的方式
	 * @author zhangnianlei
	 * @date 2020/9/14
	 * @exception
	 * @param: root
	 * @return: java.util.List<java.lang.Integer>
	 * @modifier
	 */
//	public List<Integer> inorderTraversal2(TreeNode root) {
//
//
//	}
}
