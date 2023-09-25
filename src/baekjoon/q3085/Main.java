package baekjoon.q3085;

import java.io.*;

public class Main {
    //  KB      ms      B
    //  0       0 	    0
    public static void main(String[] args) throws IOException {

        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {

    int hiScore;
    int size;
    char[][] board;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void solution() throws IOException {

        this.size = Integer.parseInt(br.readLine());

        // 여백있는 배열에 값 넣기.
        board = new char[size + 2][size + 2];

        for (int i = 0; i < size; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                board[i + 1][j + 1] = line[j];
            }
        }

        //모든 경우의 수 반복
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                bom(i, j);
            }
        }
        bwWriteIntToStr(hiScore);

        bw.close();
        br.close();
    }

    private void bom(int i, int j) {

        int[] difY = {1, 0};
        int[] difX = {0, 1};

        for (int k = 0; k < 2; k++) {
            if (board[i + difY[k]][j + difX[k]] == 0 || board[i + difY[k]][j + difX[k]] == board[i][j]) {
                continue;
            }
            //위치 변경
            changeChar(i, j, difX[k], difY[k]);

            getScore();
            //위치 원상복구
            changeChar(i, j, difX[k], difY[k]);
        }

    }

    private void getScore() {
        int maxScore = 1;

        //row 별 조회
        for (int i = 1; i < size + 1; i++) {
            int tempScore = 1;
            for (int j = 2; j < size + 1; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    tempScore++;
                } else {
                    tempScore = 1;
                }
                maxScore = Math.max(tempScore, maxScore);
            }
        }

        //column 별 조회
        for (int j = 1; j < size + 1; j++) {
            int tempScore = 1;
            for (int i = 2; i < size + 1; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    tempScore++;
                } else {
                    tempScore = 1;
                }
                maxScore = Math.max(tempScore, maxScore);
            }
        }
        hiScore = Math.max(maxScore, hiScore);
    }

    private void changeChar(int i, int j, int difX, int difY) {
        char temp = board[i][j];
        board[i][j] = board[i + difY][j + difX];
        board[i + difY][j + difX] = temp;
    }

    void bwWriteIntToStr(int i) throws IOException {
        bw.write(String.valueOf(i));
    }
}
