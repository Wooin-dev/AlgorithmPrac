package baekjoon.q1012;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int caseCnt;
    static boolean[][] map;


    static void dfs(int y, int x) {
        map[y][x] = false;
        if(map[y+1][x]) dfs(y+1,x);
        if(map[y][x+1]) dfs(y,x+1);
        if(map[y-1][x]) dfs(y-1,x);
        if(map[y][x-1]) dfs(y,x-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        caseCnt = Integer.parseInt(br.readLine());

        for(int test=0; test<caseCnt; test++) {
            // 테스트 케이스별 수행.
            StringTokenizer st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int cabCnt = Integer.parseInt(st.nextToken());

            // 배추가 심어진 정보 map 생성
            map = new boolean[height+2][width+2];

            for (int j=0; j<cabCnt; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y+1][x+1] = true;
            }

            // 순회하며 해충심기 + 카운트
            int count =0;
            for(int i=0; i<height+1; i++) {
                for (int j=0; j<width+1; j++) {
                    if (map[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println("count = " + count);
            bw.write(String.valueOf(count));
            bw.newLine();

        }
        bw.close();
        br.close();
    }
}
