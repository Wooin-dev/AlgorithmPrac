package programmers.멀리뛰기;

public class Prac {

    public static void main(String[] args) {

//        String numbers = "aukks";
        int i = 3;

        Solution solution = new Solution();
        solution.solution(i);
    }


}

class Solution {

    public int solution(int n) {

        int[] jump = new int[n+1];

        jump[0] = 0;
        jump[1] = 1;
        jump[2] = 2;

        if (n>2) {
            for (int i=3; i<n+1; i++) {
                jump[i] = (jump[i-1]%1234567 + jump[i-2]%1234567)%1234567;
            }
        }
        return jump[n];
    }
}