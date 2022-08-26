package java.LeetCode.myCode;

/**
 * @ClassName java.com.leetcode.myCode.lc86
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/19 11:49
 * @Version 1.0
 */
public class lc86 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode(-999, head);
        ListNode p1 = s, p2 = head;

        while (p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }
        p2 = p1;

        while (p2.next != null){

            if (p2.next.val >= x){
                p2 = p2.next;
            } else {
                ListNode temp = p1.next;
                p1.next = p2.next;
                p1 = p1.next;
                p2.next = p1.next;
                p1.next = temp;
            }

        }
        return s.next;
    }

}
