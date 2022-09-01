//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics数组 | 双指针 | 二分查找 
//
// 👍 210, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [剑指 Offer 57]和为s的两个数字
//解题思路: 双指针，指针分别从头尾出发，小于目标值则头指针前进，大于则尾指针前进
//题目状态: AC
public class Offer57{
    public static void main(String[] args) {
        Solution solution = new Offer57().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int head = 0;
        int trail = nums.length - 1;
        while (head < trail) {
            if (nums[head] + nums[trail] == target) {
                return new int[] {nums[head], nums[trail]};
            } else if (nums[head] + nums[trail] > target) {
                trail--;
            } else if (nums[head] + nums[trail] < target) {
                head++;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}