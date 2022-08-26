package java.LeetCode.myCode;

public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        if (n == 0) return s;
        String a = s.substring(0, n-1);
        String b = s.substring(n);

        String res = String.join(b, a);

        return res;
    }

    public static void main(String[] args) {
        System.out.println("abcdef".substring(0, 4));
        String ss = "123456";
        String s1 = "123456";
        String s2 = s1 + ss;
        System.out.println(s2);
    }

}
