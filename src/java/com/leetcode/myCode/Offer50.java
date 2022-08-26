package java.LeetCode.myCode;

import java.util.HashMap;

public class Offer50 {

    String s = "abaccdeff";
    public char firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){map.put(c, 1);}
            else {map.put(c, map.get(c)+1);}
        }

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();
        System.out.println(offer50.firstUniqChar(offer50.s));
    }
}
