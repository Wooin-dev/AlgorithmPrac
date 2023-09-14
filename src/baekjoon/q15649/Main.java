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

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void solution() throws IOException {

        // 최대 수, 배열크기 지정.
        String[] nums = br.readLine().split(" ");
        maxNum = Integer.parseInt(nums[0]);
        maxCnt = Integer.parseInt(nums[1]);

        int[] used = new int[maxNum + 1]; //숫자가 인덱스랑 같게 +1 해주기
        permutation(0, used);

        bw.close();
        br.close();
    }

    private void permutation(int cnt, int[] used) throws IOException {
        // 카운트가 맥스 넘어가면 끝. 처음엔 0. 출력된 숫자가 곧 cnt.
        if (cnt >= maxCnt) {
            bw.newLine();
            return;
        } else {

            // 출력할 숫자가 used에 있는지 확인
            for (int i = 1; i <= maxNum; i++) {
                // 있으면 다음 숫자로 넘기기
                if (used[i] == 1) continue;
                // 없으면 출력하고 used에 표시
                used[i] = 1;
                bwWriteIntToStr(i);
                bw.write(" ");
                permutation(cnt + 1, used);
                used[i] = 0;
            }
        }
    }

    void bwWriteIntToStr(int i) throws IOException {
        bw.write(String.valueOf(i));
//        bw.newLine();
    }
}