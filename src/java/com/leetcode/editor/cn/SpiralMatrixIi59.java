//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 841, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [59]螺旋矩阵 II
//解题思路: 类似lc54
//题目状态: AC，注意边界和循环
public class SpiralMatrixIi59{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi59().new Solution();
        solution.generateMatrix(3);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int leftBound = 0, rightBound = n-1, upBound = 0, downBound = n-1;
        int current = 0;
        int[][] result = new int[n][n];
        int x = 0, y = 0;
//        result[x][y] = ++current;

        while (current < n*n){
            for (int i = leftBound; i <= rightBound; i++) {
                result[upBound][i] = ++current;
            }
            upBound++;
            for (int i = upBound; i <= downBound; i++) {
                result[i][rightBound] = ++current;
            }
            rightBound--;
            for (int i = rightBound; i >= leftBound; i--) {
                result[downBound][i] = ++current;
            }
            downBound--;
            for (int i = downBound; i >= upBound; i--) {
                result[i][leftBound] = ++current;
            }
            leftBound++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}