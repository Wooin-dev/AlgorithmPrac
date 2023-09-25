package baekjoon.solved.q2606_바이러스;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //  KB      ms      B
    //  14280	124	    1370
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    boolean[][] graph;
    int count;
    boolean[] visited;

    void solution() throws IOException {

        int cpu = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        count = 0;

        graph = new boolean[cpu+1][cpu+1];

        // graph 생성
        for (int i=0; i<connect; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        visited = new boolean[cpu+1];

        dfs(1);

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }

    private void dfs(int cpu) {
        visited[cpu] = true;
        for (int i =0; i< graph.length; i++) {
            if (graph[cpu][i] && !visited[i]) {
                graph[cpu][i]=false;
                dfs(i);
                count++;
            }
        }
    }
}
