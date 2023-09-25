package baekjoon.q2667_단지번호붙이기;

import java.io.*;

public class Main {
    //  KB      ms      B
    //
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[][] map;


    void solution() throws IOException {

        int size = Integer.parseInt(br.readLine());

        map = new boolean[size+2][size+2];

        for (int i =1; i<size+1; i++) {

            String line = br.readLine();
            int j = 1;
            for (char ch : line.toCharArray()) {
//                map[j][i] = Integer
            }

        }



        bw.close();
        br.close();
    }
}