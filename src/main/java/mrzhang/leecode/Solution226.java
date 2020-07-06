package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/7/6
 *
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution226 {

	public static TreeNode invertTree(TreeNode root) {
		if (null == root) {
			return root;
		}
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		invertTree(root.right);
		invertTree(root.left);
		return root;
	}

	public static void main(String[] args) {

	}
}
