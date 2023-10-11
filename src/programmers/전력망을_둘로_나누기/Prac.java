package programmers.전력망을_둘로_나누기;

public class Prac {

    public static void main(String[] args) {

        int n = 9;
        int [][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};


        Solution solution = new Solution();
        solution.solution(n, wires);
    }


}

class Solution {

    boolean[][] graph;
    boolean[] visited;

    int n;
    int answer;
    int count;

    public int solution(int n, int[][] wires) {
        //초기화
        this.n=n;
        this.answer = n+1;

        //그래프 표기
        graph = new boolean[n+1][n+1];

        for(int[] wire : wires) {

            int from = wire[0];
            int to = wire[1];
            graph[from][to] = graph[to][from] = true;
        }

        //완전 탐색 dfs
        visited = new boolean[n+1];

        for(int i=0; i<wires.length; i++) {
            int[] wire = wires[i];

            int a = wire[0];
            int b = wire[1];

            visited[a] = visited[b] = true;
            count = 0;
            int cntA = dfs(a);

            visited[a] = visited[b] = true;
            count = 0;
            int cntB = dfs(b);

            answer = Math.min(answer, Math.abs(cntA-cntB));
            visited[a] = visited[b] = false;
        }



        return answer;
    }

    int dfs(int idx) {
        count++;
        visited[idx] = true;
        for(int i=0; i<n+1; i++) {
            if(graph[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
        visited[idx] = false;
        return count;
    }
}