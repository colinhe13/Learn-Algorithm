//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 8266, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

//Java: [3]无重复字符的最长子串
//解题思路: 滑动窗口
//题目状态: AC
public class LongestSubstringWithoutRepeatingCharacters3{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters3().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;

        int start = 0, end = 0;
        int maxLength = 1;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(s.charAt(0));

        while (end < s.length()-1){
            end++;
            char c = s.charAt(end);
            if (hashSet.contains(c)){
                while (hashSet.contains(c)){
                    hashSet.remove(s.charAt(start));
                    start++;
                }
            } else {
                if (end - start + 1 > maxLength){
                    maxLength = end - start + 1;
                }
            }
            hashSet.add(c);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}