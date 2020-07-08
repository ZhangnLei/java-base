package mrzhang.leecode;


/**
 * @author zhangnianlei
 * @date 2020/7/8
 *
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution109 {

	// 没弄懂全局变量node是如何使用的 ⭐️
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		int n = 0;
		node = head;
		while(head != null){
			head = head.next;
			n++;
		}
		return toBST(0, n-1);
	}

	/**
	 * @description 使用递归模拟中序遍历过程，建立节点的顺序即与链表元素顺序一一对应，bottom-up建立树，最终返回根节点。
	 * 递归前需要统计链表长度n，整体算法复杂度O(N)。
	 *
	 * @author zhangnianlei
	 * @date 2020/7/8
	 * @exception
	 * @param: left
	 * @param: right
	 * @return: mrzhang.leecode.TreeNode
	 * @modifier
	 */
	private TreeNode toBST(int left, int right){
		if (left > right) return null;
		int m = (left + right) / 2;
		TreeNode left_child = toBST(left, m-1);
		TreeNode father = new TreeNode(node.val);
		node = node.next;
		father.left = left_child;
		father.right = toBST(m+1, right);
		return father;
	}


	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		// 构建一个ListNode
		ListNode listNode = ListNode.getListNode(nums);
		Solution109 solution109 = new Solution109();
		TreeNode root = solution109.sortedListToBST(listNode);
		TreeNode.prePrint(root);
	}


}
