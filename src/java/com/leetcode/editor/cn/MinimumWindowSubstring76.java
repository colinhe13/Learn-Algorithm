//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2204, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [76]最小覆盖子串
//解题思路: 滑动窗口
//题目状态: AC
public class MinimumWindowSubstring76{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring76().new Solution();
        System.out.println(solution.minWindow("bba", "ab"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        // 判断非法状态
        if (t.length() > s.length()) return "";
        // 初始化标记数组
        int[] need = new int[150];
        int[] window = new int[150];
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            int index = (int) t.charAt(i);
            if (need[index] == 0) count++;
            need[index]++;
        }
        // 初始化指针
        int left = 0;
        int right = 0;
        int valid = 0;
        String result = "";
        while (right < s.length()){
            char r = s.charAt(right);
            right++;
            if (need[(int) r] > 0){
                window[(int) r]++;
                if (window[(int) r] == need[(int) r]) valid++;
            }
            if (valid == count){
                if (result.equals("") || result.length() > right - left){
                    result = s.substring(left, right);
                }
            }
            while (valid == count){
                char l = s.charAt(left);
                if (result.length() > right - left){
                    result = s.substring(left, right);
                }

                left++;
                if (need[(int) l] > 0){
                    window[(int) l]--;
                    if (window[(int) l] < need[(int) l]) valid--;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}