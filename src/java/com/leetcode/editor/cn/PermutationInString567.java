//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 778, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java: [567]字符串的排列
//解题思路: 滑动窗口的标准模版
//题目状态: AC
public class PermutationInString567{
    public static void main(String[] args) {
        Solution solution = new PermutationInString567().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 数组来记录更方便
        int[] need = new int[150];
        int[] windows = new int[150];
        for (int i = 0; i < s1.length(); i++) {
            need[(int) s1.charAt(i)]++;
        }
        int count = 0;  // 用count记录s1中不同的字符的个数，对应下面的valid
        for (int i = 80; i < 150; i++) {
            if (need[i] > 0) count++;
        }
        // 滑动窗口
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()){
            int index = (int) s2.charAt(right);
            right++;
            if (need[index] > 0){   // 如果右指针指向的字符是s1中的，则记录
                windows[index]++;
                if (windows[index] == need[index]){ // 判断同一个字符在窗口中的数量和s1中是否相等，如果相等则用valid记录，valid代表符合要求的字符的个数
                    valid++;
                }
            }
            while (right - left >= s1.length()){
                if (valid == count) return true;    // 如果窗口中满足上面条件的字符个数等于s1中的字符个数，则确认找到并返回
                int indexLeft = (int) s2.charAt(left);
                left++;
                if (need[indexLeft] > 0){   // 这里判断>0是为了排除s1中没有的字符的干扰
                    if (windows[indexLeft] == need[indexLeft]) valid--;
                    windows[indexLeft]--;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}