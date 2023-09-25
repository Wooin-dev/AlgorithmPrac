package programmers.타겟넘버;

public class Prac {

    public static void main(String[] args) {

//        String numbers = "aukks";
        int[] numbers = {4,1,2,1};
        int target = 4;


        Solution solution = new Solution();
        solution.solution(numbers, target);
    }


}

class Solution {


    int[] numbers;
    int target;
    int count;
    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;

        count = 0;

        dfs(0, 0);

        return count;
    }

    private void dfs(int sum, int depth) {
        if (depth>= numbers.length) {
            if (sum==target) count++;
            return;
        }
        dfs(sum+numbers[depth], depth+1);
        dfs(sum-numbers[depth], depth+1);
    }
}