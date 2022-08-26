package java.LeetCode.myCode;

/**
 * @ClassName java.com.leetcode.myCode.lc141
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/26 09:35
 * @Version 1.0
 */
public class lc141 {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

     public boolean hasCycle(ListNode head) {
           if (head == null || head.next == null)
                return false;
           ListNode fast = head;
           ListNode slow = head;

           while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                     return true;
           }

           return false;
     }


}
