package java.LeetCode.myCode;

import java.util.Deque;
import java.util.LinkedList;

public class Offer24 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {return null;}
            ListNode cur = head;
            Deque<ListNode> stack = new LinkedList<>();
            while (cur != null){
                stack.addFirst(cur);
                cur = cur.next;
            }
            cur = stack.removeFirst();
            cur.next = stack.peekFirst();
            ListNode newHead = cur;
            while (!stack.isEmpty()){
                cur = stack.removeFirst();
                cur.next = stack.peekFirst();
            }
            return newHead;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
