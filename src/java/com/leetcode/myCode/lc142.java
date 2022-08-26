package java.LeetCode.myCode;

/**
 * @ClassName java.com.leetcode.myCode.lc142
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/26 09:54
 * @Version 1.0
 */
public class lc142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode fast = head.next; // 注意这里要保持fast的索引是slow的两倍
        ListNode slow = head;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode circleStartPoint = head;
        fast = fast.next;

        while (fast != circleStartPoint){
            circleStartPoint = circleStartPoint.next;
            fast = fast.next;
        }

        return circleStartPoint;
    }

}
