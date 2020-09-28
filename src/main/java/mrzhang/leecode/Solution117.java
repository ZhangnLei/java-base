package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2020/9/28
 */
public class Solution117 {
	/**
	 * 117. 填充每个节点的下一个右侧节点指针 II 难度 中等
	 * 给定一个二叉树
	 *
	 * struct Node {
	 *   int val;
	 *   Node *left;
	 *   Node *right;
	 *   Node *next;
	 * }
	 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
	 *
	 * 初始状态下，所有 next 指针都被设置为 NULL。
	 * 进阶：
	 *
	 * 你只能使用常量级额外空间。
	 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
	 *
	 *
	 * 示例：
	 * 输入：root = [1,2,3,4,5,null,7]
	 * 输出：[1,#,2,3,#,4,5,7,#]
	 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
	 *
	 *
	 * 提示：
	 *
	 * 树中的节点数小于 6000
	 * -100 <= node.val <= 100
	 */

	/**
	 * 思路：递归，从第一层开始 在第i层时可以为i+1层添加next指针
	 */

	/**
	 * 迭代实现方式
	 *
	 * @param root
	 * @return
	 */
	public Node connect1(Node root) {
		Node current = root;
		Node next = current.next;
		while (null != current) {
			while (null != current) {
				if (null == current.left && null == current.right) {
					// 没有左右两个节点
					current = current.next;
					break;
				} else if (null != current.left && null != current.right) {
					current.left.next = current.right;
					if (null != next) {

					}
				}
				current = current.next;
				next = current.next;
			}
			// 切换层
			current = current.left;
		}


		return root;
	}


//	题解
	/**
题解
	 */



	/**
	 * 递归实现方式
	 *
	 * @param root
	 * @return
	 */
	public Node connect2(Node root) {
		Node currentLayer = root;
		Node nextLayer = root.left == null ? root.right : root.left;
		while (null != currentLayer) {
			while (null != currentLayer && null != nextLayer) {
			}
			// 切换层
			currentLayer = currentLayer.left;
		}
		return root;
	}

	/** 上一个节点 */
	private Node last = null;
	/** 下一层开始的节点 */
	private Node nextStart = null;

	public Node connect(Node root) {
		Node start = root;
		while (null != start) {
			last = null;
			nextStart = null;
			for (Node p = start; p != null; p = p.next) {
				if (null != p.left) handle(p.left);
				if (null != p.right) handle(p.right);
			}
			start = nextStart;
		}
		return root;
	}

	public void handle(Node p) {
		if (last != null) {
			last.next = p;
		}
		if (nextStart == null) {
			nextStart = p;
		}
		last = p;
	}

}

//class Solution {
//	Node last = null, nextStart = null;
//
//	public Node connect(Node root) {
//		if (root == null) {
//			return null;
//		}
//		Node start = root;
//		while (start != null) {
//			last = null;
//			nextStart = null;
//			for (Node p = start; p != null; p = p.next) {
//				if (p.left != null) {
//					handle(p.left);
//				}
//				if (p.right != null) {
//					handle(p.right);
//				}
//			}
//			start = nextStart;
//		}
//		return root;
//	}
//
//	public void handle(Node p) {
//		if (last != null) {
//			last.next = p;
//		}
//		if (nextStart == null) {
//			nextStart = p;
//		}
//		last = p;
//	}
//}
//
//作者：LeetCode-Solution
//		链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/
//		来源：力扣（LeetCode）
//		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
