package java.LeetCode.myCode;

public class Offer04 {

//    int[][] matrix = {
//            {1, 4, 7, 11, 15},
//            {2, 5, 8, 12, 19},
//            {3, 6, 9, 16, 22},
//            {10, 13, 14, 17, 24},
//            {18, 21, 23, 26, 30}
//            };
//    int target = 22;

//    int[][] matrix = {{1,2,3,4,5}};
//    int target = 15;

    int[][] matrix = {{1,  2,  3,  4,  5},
                      {6,  7,  8,  9,  10},
                      {11, 12, 13, 14, 15},
                      {16, 17, 18, 19, 20},
                      {21, 22, 23, 24, 25}};
    int target = 15;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int n = matrix.length-1;
        int m = matrix[0].length-1;

        if (matrix[n][m] < target ){
            return false;
        }else if (matrix[n][m] == target){
            return true;
        }

        while (n >= 0 && m >= 0 && matrix[n][m] > target){

            if (matrix[0][m] <= target){
                for (int i = 0; i <= n; i++) {
                    if (matrix[i][m] == target) return true;
                }
            }

            if (matrix[n][0] <= target){
                for (int i = 0; i <= m; i++) {
                    if (matrix[n][i] == target) return true;
                }
            }

            n = n-1;
            if (n < 0) return false;
            m = m-1;
            if (m < 0) return false;
            if (matrix[n][m] == target) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();
        System.out.println(offer04.findNumberIn2DArray(offer04.matrix, offer04.target));
    }

}
