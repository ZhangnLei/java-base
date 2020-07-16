package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/7/6
 */
public class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

	/**
	 * @description 中序遍历打印二叉树
	 * @author zhangnianlei
	 * @date 2020/7/7
	 * @exception
	 * @param: root
	 * @modifier
	 */
	public static void prePrint(TreeNode head) {
		if (head == null) {
			return;
		}
		prePrint(head.left);
		System.out.println(head.val);
		prePrint(head.right);
	}

}
