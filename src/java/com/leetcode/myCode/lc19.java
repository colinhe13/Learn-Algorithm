package java.LeetCode.myCode;

/**
 * @ClassName java.com.leetcode.myCode.lc19
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/26 11:30
 * @Version 1.0
 */
public class lc19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode preHead = new ListNode(-1, head);
//
//        ListNode slow = preHead;
//        ListNode fast = preHead;

        ListNode slow = head;
        ListNode fast = head;

        if (head.next == null){
            return null;
        }

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        if (n == 1){
            slow.next = null;
        } else {
            slow.next = fast;
        }
        return head;
    }

}
