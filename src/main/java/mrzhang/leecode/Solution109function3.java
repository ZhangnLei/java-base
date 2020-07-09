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
public class Solution109function3 {

	private ListNode head;

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9, 13};
		// 构建一个ListNode
		ListNode listNode = ListNode.getListNode(nums);
		Solution109function3 solution109 = new Solution109function3();
		TreeNode root = solution109.sortedListToBST(listNode);
		TreeNode.prePrint(root);
	}

	/**
	 * @description 109 方法三 逆用中序遍历的思想：中序遍历二叉搜索树得到一个升序数列，那么反过来，使用此法将一个升序的数列构建成一个二叉搜索树
	 * @author zhangnianlei
	 * @date 2020/7/9
	 * @exception
	 * @param: node
	 * @return: mrzhang.leecode.TreeNode
	 * @modifier
	 */
	private TreeNode sortedListToBST(ListNode node) {
		// 计算listNode的长度
		int size = countListNodeSize(node);
		// 使用全局的ListNode变量协助
		head = node;
		// 构建二叉搜索树
		return convertListToBST(0, size - 1);
	}


	private TreeNode convertListToBST(int left, int right) {
		if (right < left) return null;
		int mid = (right + left) / 2;
		TreeNode leftNode = convertListToBST(left, mid - 1);
		TreeNode result = new TreeNode(head.val);
		result.left = leftNode;
		head = head.next;
		result.right = convertListToBST(mid + 1, right);
		return result;
	}


	private int countListNodeSize(ListNode head) {
		if (head == null) return 0;
		int sum = 0;
		ListNode p = head;
		while (p != null) {
			sum += 1;
			p = p.next;
		}
		return sum;
	}


}
