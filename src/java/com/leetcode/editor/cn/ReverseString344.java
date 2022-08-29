//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
// Related Topics递归 | 双指针 | 字符串 
//
// 👍 652, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [344]反转字符串
//解题思路: 双指针，分别从前往后和从后往前扫描交换，直到相遇
//题目状态: AC
public class ReverseString344{
    public static void main(String[] args) {
        Solution solution = new ReverseString344().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            char cur = s[left];
            s[left] = s[right];
            s[right] = cur;
            left++;
            right--;
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}