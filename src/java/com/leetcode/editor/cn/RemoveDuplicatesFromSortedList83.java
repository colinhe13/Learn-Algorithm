//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics链表 
//
// 👍 843, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import com.leetcode.editor.ListNode;

//Java: [83]删除排序链表中的重复元素
//解题思路: 双指针，快指针跳过相同的元素，慢指针指向处理完的位置，注意要处理末尾
//题目状态: AC
public class RemoveDuplicatesFromSortedList83{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList83().new Solution();
        
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        // 链表中没有节点，直接返回
        if (slow == null) return null;
        ListNode fast = head.next;
        // 链表中只有一个节点，直接返回
        if (fast == null) return head;
        while (fast != null) {
            // 如果两个节点的值相同，则快指针向后移动
            if (slow.val == fast.val) {
                fast = fast.next;
            // 如果两个节点值不同，则删除两指针间的节点，同时两指针向后移动
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        // 处理末尾
        slow.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}