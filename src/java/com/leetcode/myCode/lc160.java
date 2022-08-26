package java.LeetCode.myCode;

/**
 * @ClassName java.com.leetcode.myCode.lc160
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/26 10:57
 * @Version 1.0
 */
public class lc160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        int node1 = 0;
        int node2 = 0;

        while (p1 != null){
            node1++;
            p1 = p1.next;
        }
        while (p2 != null){
            node2++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;

        if (node1 > node2){
            while (node1 != node2){
                p1 = p1.next;
                node1--;
            }
        }else if (node1 < node2){
            while (node1 != node2){
                p2 = p2.next;
                node2--;
            }
        }

        while (p1 != null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

}
