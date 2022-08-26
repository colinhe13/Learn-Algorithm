package java.LeetCode.myCode;

class Solution {
        public int[] twoSum(int[] nums, int target) {

            int[] result = null;
            for (int i = 0; i < nums.length-1; i++) {
                int current = target - nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] == current){

                        return new int[]{i, j};
                    } else continue;
                }
            }
            return null;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.twoSum(new int[]{2, 7, 11, 15},9));
        }

    }

