//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics数组 | 双指针 
//
// 👍 1717, 👎 0 
//
//
//
//

package com.leetcode.editor.cn;

//Java: [283]移动零
//解题思路: 快慢指针，慢指针指向第一个0元素，快指针找非0元素并交换
//题目状态: AC，思路可以改进（先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。）
public class MoveZeroes283{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes283().new Solution();
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        solution.moveZeroes(nums);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        if (length == 1) {
            return;
        }
        // 找第一个0元素
        while (nums[left] != 0) {
            left++;
            right++;
            // 数组中没有0，直接返回
            if (left == length) return;
        }

        while (right < length) {
            // 找非0元素，找到了和左指针交换
            while (nums[right] == 0) {
                right++;
                // 如果没有非0元素，说明交换完毕，直接返回
                if (right == length) return;
            }
            // 交换
            int cur = nums[left];
            nums[left] = nums[right];
            nums[right] = cur;

            left++;
            right++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
