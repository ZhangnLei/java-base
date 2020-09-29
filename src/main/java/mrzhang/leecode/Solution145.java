package mrzhang.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/9/29
 *
 * 145. 二叉树的后序遍历
 * 难度
 * 中等
 *
 * 431
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class Solution145 {

	private List<Integer> resultList = null;
	// 后序遍历 即为最后记录根节点
	public List<Integer> postorderTraversal(TreeNode root) {
		resultList = new ArrayList<>();
		handerNode(root);
		return resultList;
	}

	public void handerNode (TreeNode node) {
		if (node == null) return;
		handerNode(node.left);
		handerNode(node.right);
		resultList.add(node.val);
	}

}
