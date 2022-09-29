//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics递归 | 链表 
//
// 👍 1817, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import com.leetcode.editor.ListNode;

//Java: [25]K 个一组翻转链表
//解题思路: 递归地执行反转函数，还用了虚拟头节点
//题目状态: AC，实际上反转链表一定区间内的元素可以用迭代的方法，一定程度上可以简化代码？
public class ReverseNodesInKGroup25{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup25().new Solution();
        
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(-1, head);
        ListNode end = head;
        int starti = 0, endi = 1;
        int flagFirst = 0;
        while (end != null){
            if (endi - starti == k){
                end = start.next;
                starti = endi;
                start.next = reverseN(start.next, k);
                if (flagFirst == 0){
                    head = start.next;
                    flagFirst = 1;
                }
                start = end;
            }
            end = end.next;
            endi++;
        }
        return head;
    }

    // 反转前n个节点的递归函数
    ListNode suc = null;
    public ListNode reverseN(ListNode node, int n){
        if (n == 1){
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