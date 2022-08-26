package java.LeetCode.myCode;

public class Offer11 {

    int[] numbers = {1,1};
//    int[] numbers = {3,4,5,1,2};

    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) return 0;
        if (numbers[0] < numbers[len-1] || len == 1) return numbers[0];
        int point = 0;
        while (point < len-1 && numbers[point] <= numbers[point+1]){
                point = point + 1;
        }
        if (point == len-1) {
            point = point - 1;
        }
        return numbers[point+1];
    }

    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        System.out.println(offer11.minArray(offer11.numbers));
    }

}
