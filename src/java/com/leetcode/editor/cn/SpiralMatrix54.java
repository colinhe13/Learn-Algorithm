//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1232, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java: [54]螺旋矩阵
//解题思路: 当前思路：辅助矩阵  参考思路：按右下左上顺序遍历，用四个变量确定未遍历的元素的边界
//题目状态: AC
public class SpiralMatrix54{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix54().new Solution();
        solution.spiralOrder(new int[][]{{1},{5},{9}});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] flags = new int[n][m];
        int x = 0, y = -1;
        List<Integer> result = new ArrayList<>();

        while (y < m-1 && flags[x][y+1] == 0){
            // 向右遍历
            while (y < m-1 && flags[x][y+1] == 0){
                y++;
                result.add(matrix[x][y]);
                flags[x][y] = 1;
            }
            // 向下遍历
            while (x < n-1 && flags[x+1][y] == 0){
                x++;
                result.add(matrix[x][y]);
                flags[x][y] = 1;
            }
            // 向左遍历
            while (y > 0 && flags[x][y-1] == 0){
                y--;
                result.add(matrix[x][y]);
                flags[x][y] = 1;
            }
            // 向上遍历
            while (x > 0 && flags[x-1][y] == 0){
                x--;
                result.add(matrix[x][y]);
                flags[x][y] = 1;
            }
        }

//        System.out.println(Arrays.deepToString(flags));

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}