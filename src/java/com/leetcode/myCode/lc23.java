package java.LeetCode.myCode;

import java.util.PriorityQueue;

/**
 * @ClassName java.com.leetcode.myCode.lc23
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/19 14:47
 * @Version 1.0
 */
public class lc23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode r = new ListNode(-1);
        r.next = lists[0];
        ListNode p1 = r.next;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>();



        for (int i = 1; i < lists.length; i++) {
            ListNode p2 = lists[i];

        }


        return lists[0];
    }


}
