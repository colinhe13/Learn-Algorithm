package java.LeetCode.myCode;

import java.util.ArrayList;
import java.util.List;

public class Offer06 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head == null){
                return new int[0];
            }
            List<Integer> list = new ArrayList<Integer>();
            while (head.next != null){
                list.add(head.val);
                head = head.next;
            }
            list.add(head.val);

            int[] res = new int[list.size()];
            for (int i = list.size(); i > 0; i--) {
                res[i] = list.get(list.size()-i);
            }
            return res;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
