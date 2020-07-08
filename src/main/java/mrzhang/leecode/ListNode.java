package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2019/10/20
 */
public 	class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}


	public static ListNode getListNode(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		ListNode head = new ListNode(nums[0]);
		ListNode node = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode next = new ListNode(nums[i]);
			node.next = next;
			node = node.next;
		}
		pringListNode(head);
		return head;
	}


	private static void pringListNode(ListNode head) {
		StringBuilder sb = new StringBuilder("ListNode : ");
		if (head == null) {
			return;
		}
		ListNode node = head;
		while (node != null) {
			sb.append((String.valueOf(node.val)));
			sb.append(" ");
			node = node.next;
		}
		System.out.println(sb.toString());
	}

}