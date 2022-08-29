//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics字符串 | 动态规划 
//
// 👍 5631, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [5]最长回文子串
//解题思路: 判断回文串一般思路都是从中间开始向两边找，定义一个查找回文串的函数
//题目状态: AC，但思路不清晰
public class LongestPalindromicSubstring5{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring5().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = findPalindrome(s, i, i);
            if (res1.length() > res.length()) res = res1;
//            if (i == s.length()-1) return res;
            String res2 = findPalindrome(s, i, i+1);
            if (res2.length() > res.length()) res = res2;
        }
        return res;
    }

    public String findPalindrome(String s, int l, int r) {
//        if (s.charAt(l) != s.charAt(r)) return "";
//        while (s.charAt(l) == s.charAt(r)) {
//                l--;
//                r++;
//                if (l == -1 || r == s.length()) break;
//        }
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}