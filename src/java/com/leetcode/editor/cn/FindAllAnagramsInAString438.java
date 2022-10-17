//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1027, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java: [438]找到字符串中所有字母异位词
//解题思路: 滑动窗口+保存状态
//题目状态: AC，思路待改进，滑动窗口中左右指针都可以根据情况移动的，也就是说右指针一直前进，左指针根据情况控制窗口收缩（超过大小就收缩），在大小符合的情况下判断是否满足条件
public class FindAllAnagramsInAString438{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString438().new Solution();
        System.out.println(solution.findAnagrams("abacbabc", "abc"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 判断非法状态
        if (p.length() > s.length()) return new ArrayList<>();
        // 设置标记数组
        int[] origin = new int[150];
        for (int i = 0; i < p.length(); i++) {
            origin[(int) p.charAt(i)]++;
        }
        int[] tags = origin.clone();
        // 设置结果列表
        ArrayList<Integer> resultList = new ArrayList<>();
        // 滑动窗口
        int windows = p.length();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            for (int j = i; j < i + windows; j++) {
                if (tags[(int) s.charAt(j)] > 0){
                    tags[(int) s.charAt(j)]--;
                } else {
                    tags = origin.clone();
//                    if (tags[(int) s.charAt(j)] > 0){
//                        i = j - 1;
//                    } else {
//                        i = j;
//                    }
                    break;
                }
                if (j - i + 1 == windows){
                    resultList.add(i);
                    tags = origin.clone();
                }
            }
        }
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}