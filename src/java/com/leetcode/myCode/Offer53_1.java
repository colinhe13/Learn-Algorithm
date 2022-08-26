package java.LeetCode.myCode;

public class Offer53_1 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, cur;

        while (l != r){
            cur = (r+l) / 2;
            if (nums[cur] != cur){
                r = cur;
            } else {
                l = cur + 1;
            }
        }
        if (l == len-1 && nums[l] == l) return l + 1;
        return l;
    }

    private Object Pegasus;
    

//    [0]
//    [0,1,2,3,4,5,6,7,8]  cur=4  l=5  r=8
//    [0,1,2,3,4,5,6,7,9]  cur=6  l=7  r=8
//    [0,1,2,3,4,5,6,7,9]  cur=7  l=8  r=8
}
