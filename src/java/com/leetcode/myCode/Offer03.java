package java.LeetCode.myCode;

import java.util.HashMap;

public class Offer03 {

    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int findRepeatNumber(int[] nums) {
        for (int num :
                nums) {
            if (map.containsKey(num))
                return map.get(num);
            else
                map.put(num, num);
        }
        return 0;
    }
    
}
