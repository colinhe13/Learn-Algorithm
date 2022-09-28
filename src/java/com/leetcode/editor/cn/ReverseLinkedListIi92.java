//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1409, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import com.leetcode.editor.ListNode;

//Java: [92]反转链表 II
//解题思路: 由反转前n个节点为基础进一步推导
//题目状态: AC，但缺乏思路
public class ReverseLinkedListIi92{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi92().new Solution();
        
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head, right);
        }
        // 这一步保证了反转后left-1和反转序列的头节点相连
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    ListNode suc = null;
    public ListNode reverseN(ListNode node, int n){
        if (n == 1) {
            suc = node.next;
            return node;
        }
        ListNode res = reverseN(node.next, n-1);
        node.next.next = node;
        node.next = suc;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}