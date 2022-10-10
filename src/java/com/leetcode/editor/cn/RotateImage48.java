//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics数组 | 数学 | 矩阵 
//
// 👍 1446, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [48]旋转图像
//解题思路: 类似lc151，先以y=x为对称轴翻转，再以y=0为对称轴翻转
//题目状态: AC
public class RotateImage48{
    public static void main(String[] args) {
        Solution solution = new RotateImage48().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // 第一次翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-j-1][m-i-1];
                matrix[m-j-1][m-i-1] = temp;
            }
        }
        // 第二次翻转
        for (int i = 0; i < m/2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }
    }


}

// 1 2 3     9 6 3     7 4 1
// 4 5 6 --> 8 5 2 --> 8 5 2
// 7 8 9     7 4 1     9 6 3
// (0,1) --> (1,2) (2,3)
// (0,2) --> (1,3)

//leetcode submit region end(Prohibit modification and deletion)

}