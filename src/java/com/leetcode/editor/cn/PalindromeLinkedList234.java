//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1528, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import com.leetcode.editor.ListNode;

//Java: [234]回文链表
//解题思路: 找到中间节点，反转后半部分链表
//题目状态: AC，代码还可以进一步优化，找到中点后不需要截出两个队列，只要比较到后面的队列结束就可以判断
public class PalindromeLinkedList234{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList234().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, mid = head, fast = head;
        while (fast.next != null){
            // 1 1
            // 1 2 2 1
            // 1 2 3 2 1
            // 1 2 3 4 5 4 3 2 1
            if (fast.next.next == null){
                // 第一种情况：偶数
                ListNode cur = mid.next;
                mid.next = null;
                cur = reverse(cur);
                return compareList(slow, cur);
            } else if (fast.next.next.next == null) {
                // 第二种情况：奇数
                ListNode cur = mid.next.next;
                mid.next.next = null;
                mid.next = null;
                cur = reverse(cur);
                return compareList(slow, cur);
            } else {
                mid = mid.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public boolean compareList(ListNode list1, ListNode list2){
        while (list1 != null && list2 != null){
            if (list1.val != list2.val) return false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){
        if (node.next == null){
            return node;
        }
        ListNode res = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}