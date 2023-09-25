package baekjoon.solved.q9093;


import java.io.*;

public class Main {
    //  KB      ms      B
    //  45732   520 	1050
    public static void main(String[] args) throws IOException {

        Solution sol = new Solution();
        sol.solution();
    }
}
class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void solution() throws IOException {

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            String[] line = br.readLine().split(" ");

            StringBuilder sb = new StringBuilder();
            String[] answer = new String[line.length];
            int i = 0;
            for (String word : line) {
                sb.append(word).reverse();
                answer[i] = sb.toString();
                sb.setLength(0);
                i++;
            }
            String result = String.join(" ", answer);
            bw.write(result);
            bw.newLine();

        }

        bw.close();
        br.close();
    }

    void bwWriteIntToStr(int i, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(i));
        bw.newLine();
    }
}
