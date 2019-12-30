package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2019/10/20
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution002 {

    /**
     * 通过提交测试的方法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers001(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res  = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            res.next = new ListNode(sum % 10);
            res = res.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * 未通过测试
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = new ListNode(0);
        head.next = result;
        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                result.val += l2.val;
                result.next = l2.next;
                break;
            }
            if (l2 == null && l1 != null) {
                result.val += l1.val;
                result.next = l1.next;
                break;
            }
            result.val += l1.val + l2.val;
            if (result.val >= 10) {
                result.next = new ListNode(1);
                result.val -= 10;
            }
            l1 = l1.next;
            l2 = l2.next;
            if ((l1 != null || l2 != null) & result.next == null) {
                result.next = new ListNode(0);
            }
            result = result.next;
        }
        return head.next;
    }

    public static Long node2num(ListNode node) {
        Long res = 0L;
        int i = 0;
        while (node != null) {
            res += node.val * (int) Math.pow(10, i);
            node = node.next;
            i++;
        }
        return res;
    }

    public static ListNode num2node(Long num) {
        ListNode head = new ListNode(0);
        ListNode res = new ListNode(0);
        head.next = res;
        while (num > 0) {
            res.val = (int) (num % 10);
            num = num / 10;
            if (num > 0) {
                res.next = new ListNode(0);
                res = res.next;
            }
        }
        return head.next;
    }

    public static ListNode addTwoNumbers002(ListNode l1, ListNode l2) {
        return num2node(node2num(l1) + node2num(l2));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
    	ListNode head = new ListNode(0);
    	ListNode res = head;
    	int carry = 0;
    	while (l1!=null || l2!=null){
    		int x = (l1 != null) ? l1.val : 0;
    		int y = (l2 != null) ? l2.val : 0;
    		int sum = carry + x + y;
    		res.next = new ListNode(sum % 10);
    		res = res.next;
    		carry = sum / 10;
    		if (l1 != null) l1 = l1.next;
    		if (l2 != null) l2 = l2.next;
	    }
    	if (carry > 0){
    		res.next = new ListNode(carry);
	    }
    	return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//		  l1.next.next.next = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode result = addTwoNumbers002(l1, l2);
        sout(result);
    }

    private static void sout(ListNode result) {
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
	    System.out.println();
    }
}
