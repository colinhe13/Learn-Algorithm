package java.LeetCode.myCode;

import java.util.HashMap;

public class Offer53 {

    HashMap<Integer,Integer> map = new HashMap<>();

    public int search(int[] nums, int target) {
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        if (map.containsKey(target)){
            return map.get(target);
        } else {
            return 0;
        }
    }

}
