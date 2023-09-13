package baekjoon.q15649;

import java.io.*;

public class Main {
    //  KB      ms      B
    //
    public static void main(String[] args) throws IOException {

        Solution sol = new Solution();
        sol.solution();
    }
}


class Solution {

    int maxNum;
    int maxCnt;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void solution() throws IOException {

        // 최대 수, 배열크기 지정.
        String[] nums = br.readLine().split(" ");
        maxNum = Integer.parseInt(nums[0]);
        maxCnt = Integer.parseInt(nums[1]);

        for (int i = 1; i <= maxNum; i++) {
            int[] used = new int[maxNum + 1]; //숫자가 인덱스랑 같게 +1 해주기
            used[i]=1;
            printNum(i, 1, used);
            bw.newLine();
        }


        bw.close();
        br.close();
    }

    private void printNum(int i, int cnt, int[] used) throws IOException {

        bwWriteIntToStr(i);

        bw.write(" ");

        for (int j = 0; j < maxCnt; j++) {
            for (int k = i + 1; k <= maxNum; k++) {
                printNum(k, cnt+1, used);
            }
        }


    }

    void bwWriteIntToStr(int i) throws IOException {
        bw.write(String.valueOf(i));
        bw.newLine();
    }
}





