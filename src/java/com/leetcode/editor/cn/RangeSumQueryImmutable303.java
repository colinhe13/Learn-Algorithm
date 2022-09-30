//给定一个整数数组 nums，处理以下类型的多个查询: 
//
// 
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= i <= j < nums.length 
// 最多调用 10⁴ 次 sumRange 方法 
// 
//
// Related Topics设计 | 数组 | 前缀和 
//
// 👍 507, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [303]区域和检索 - 数组不可变
//解题思路: 前缀和数组，注意处理边界
//题目状态: AC
public class RangeSumQueryImmutable303{
    public static void main(String[] args) {
//        NumArray solution = new RangeSumQueryImmutable303().new NumArray();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return;
    }
    
    public int sumRange(int left, int right) {
        // nums[] 1 1 1 1
        // sums[] 1 2 3 4
        // [0,2] [1,2]
        // 3 2
        int res;
        if (left == 0){
            res = sums[right];
        } else {
            res = sums[right] - sums[left - 1];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}