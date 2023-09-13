package programmers;

public class Main {
    public static void main(String[] args) {

        String s = "a";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
 
        Solution solution = new Solution();
//        solution.solution();
    }


}
class Solution {
    // 1. 답 변수 answer static으로 선언.
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        // 2. dfs 함수 실행.
        dfs(numbers,target,0,0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum){
        // 3. 배열 마지막 노드까지 탐색이 끝났는지 체크
        if(idx == numbers.length){
            // 4. 합계와 타겟 값이 같으면 answer을 1 증가 시킴.
            if(sum == target) answer++;
        }else{
//            5. 해당 노드 값을 더하고 다음 값 탐색
            dfs(numbers, target, idx+1, sum+numbers[idx]);
//            6. 해당 노드 값을 빼고 다음 값 탐색
            dfs(numbers, target, idx+1, sum-numbers[idx]);
        }
    }
}
