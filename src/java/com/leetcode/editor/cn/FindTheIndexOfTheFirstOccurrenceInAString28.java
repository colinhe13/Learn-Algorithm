//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics双指针 | 字符串 | 字符串匹配 
//
// 👍 1617, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.util.HashSet;

//Java: [28]找出字符串中第一个匹配项的下标
//解题思路: RABIN KARP 字符匹配，用哈希滑动窗口
//题目状态: AC，本题使用了标准的 RABIN KARP 字符匹配算法模版
public class FindTheIndexOfTheFirstOccurrenceInAString28{
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString28().new Solution();
        System.out.println(solution.strStr("leetcode", "leeto"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // 初始化计算哈希值相关的数据
        int R = 256;
        int L = needle.length();
        long Q = 1658598167;
        long RL = 1;
        for (int i = 1; i <= L - 1 ; i++) {
            RL = (RL * R) % Q;
        }
        // 计算模式串的哈希值
        long patHash = 0;
        for (int i = 0; i < L; i++) {
            patHash = (patHash * R + needle.charAt(i)) % Q;
        }
        // 初始化窗口中字符串的哈希值
        long windowHash = 0;
        // 滑动窗口算法
        int left = 0, right = 0;
        while (right < haystack.length()){
            windowHash = (windowHash * R) % Q + (haystack.charAt(right)) % Q;
            right++;
            if (right - left == needle.length()){
                if (windowHash == patHash){
                    return left;
                } else {
                    windowHash = (windowHash - (haystack.charAt(left) * RL) % Q + Q) % Q;
                }
                left++;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}