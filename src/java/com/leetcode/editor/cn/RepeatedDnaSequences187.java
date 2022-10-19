//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希 
//
// 👍 428, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java: [187]重复的DNA序列
//解题思路: Rabin-Karp字符匹配算法，也就是滑动哈希算法，窗口一边滑动一边计算哈希值，用哈希值来比较字符串是否匹配
//题目状态: AC，注意转换成4进制的计算方法
public class RepeatedDnaSequences187{
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences187().new Solution();
        System.out.println();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 判断非法情况
        if (s.length() <= 10) return new ArrayList<String>();
        // 初始化哈希数组
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                array[i] = 0;
            } else if (s.charAt(i) == 'C') {
                array[i] = 1;
            } else if (s.charAt(i) == 'G') {
                array[i] = 2;
            } else if (s.charAt(i) == 'T') {
                array[i] = 3;
            }
        }
        

        HashSet<Integer> hashInt = new HashSet<>();
        HashSet<String> hashStr = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        int windowHash = 0;
        int R = 4;
        int L = 10;
        int RL = (int) Math.pow(R, L-1);

        while (right < s.length()){
            windowHash = windowHash * R + array[right];
            right++;

            if (right - left == 10){
                if (hashInt.contains(windowHash)){
                    String s1 = s.substring(left, right);
                    if (!hashStr.contains(s1)){
                        result.add(s1);
                        hashStr.add(s1);
                    }
                } else {
                    hashInt.add(windowHash);
                }
                windowHash = windowHash - array[left] * RL;
                left++;
            }
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}