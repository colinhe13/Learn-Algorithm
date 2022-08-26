package java.LeetCode.myCode;

import java.util.List;

/**
 * @ClassName java.com.leetcode.myCode.lc21
 * @Description TODO
 * @Author Colin
 * @Date 2022/7/15 12:56
 * @Version 1.0
 */
public class lc21 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 自己写的方法
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode res = new ListNode();
//        ListNode start = res;
//        while (list1 != null && list2 != null){
//            if (list1.val >= list2.val) {
//                res.next = new ListNode(list2.val);
//                list2 = list2.next;
//            } else {
//                res.next = new ListNode(list1.val);
//                list1 = list1.next;
//            }
//            res = res.next;
//        }
//        if (list1 == null && list2 != null){
//            res.next = new ListNode(list2.val, list2.next);
//        }
//        if (list2 == null && list1 != null){
//            res.next = new ListNode(list1.val, list1.next);
//        }
//        return start.next;
//    }

    // 参考答案
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode start = res;
        while (list1 != null && list2 != null){
            if (list1.val >= list2.val) {
                res.next = list2;
                list2 = list2.next;
            } else {
                res.next = list1;
                list1 = list1.next;
            }
            res = res.next;
        }
        if (list2 != null){
            res.next = list2;
        }
        if (list1 != null){
            res.next = list1;
        }
        return start.next;
    }
}
