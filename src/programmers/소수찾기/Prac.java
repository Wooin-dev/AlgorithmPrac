package programmers.소수찾기;

public class Prac {

    public static void main(String[] args) {

        String numbers = "aukks";


        Solution solution = new Solution();
        solution.solution(numbers);
    }


}

class Solution {
    public int solution(String numbers) {

        //numbers 배열로 쪼개기
        int[] cards = new int[numbers.length()];
        for (int i=0; i<numbers.length(); i++) {
            cards[i] = numbers.toCharArray()[i];
        }
        

        int answer = 0;
        //숫자들로 모든 조합 생성
        //소수인지 체크 후 카운트



        return answer;
    }
}