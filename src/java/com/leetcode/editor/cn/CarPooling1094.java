//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列） 
//
// 👍 208, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//Java: [1094]拼车
//解题思路: 前缀和数组
//题目状态: AC 思路不对，应该改成差分数组；数组用正数表示当前装载的乘客更好
public class CarPooling1094{
    public static void main(String[] args) {
        Solution solution = new CarPooling1094().new Solution();
        System.out.println(solution.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/* 一般方法，时间复杂度高 */
//    int[] road;
//
//    public boolean carPooling(int[][] trips, int capacity) {
//        // 初始化路程数组
//        road = new int[1001];
//        Arrays.fill(road, 0);
//
//        int n = trips.length;
//        for (int i = 0; i < n; i++) {
//            int numPassengers = trips[i][0];
//            int from = trips[i][1];
//            int to = trips[i][2];
//            for (int j = from; j < to; j++) {
//                road[j] = road[j] + numPassengers;
//                if (road[j] > capacity) return false;
//            }
//        }
//        return true;
//    }

/* 差分数组 */
    private int[] diff,road;

    public boolean carPooling(int[][] trips, int capacity) {
        // 构造差分数组
        diff = new int[1001];
        Arrays.fill(diff, 0);
        int n = trips.length;
        for (int i = 0; i < n; i++) {
            int nums = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            if (from > capacity) return false;
            diff[from] = diff[from] - nums;
            if (to <= 1001 ) diff[to] = diff[to] + nums;
        }

        // 根据差分数组还原原数组
        road = new int[1001];
        road[0] = capacity + diff[0];
        if (road[0] < 0) return false;
        for (int i = 1; i < 1001; i++) {
            road[i] = road[i-1] + diff[i];
            if (road[i] < 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}