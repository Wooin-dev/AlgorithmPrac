package baekjoon.q2309;

import java.io.*;
import java.util.Arrays;

public class Main {

    //  KB      ms      B
    //  14316	124     1271

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //키 배열로 받아오기
        int[] talls = new int[9];
        for (int i=0; i<9; i++) {
            talls[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(talls);

        int[] pass = new int[2];
        for (int i=0; i<8; i++) {
            for (int j=i+1; j<9; j++) {
                int sum = 0;
                for (int k=0; k<9; k++) {
                    if (k!=i && k!=j)
                        sum += talls[k];
                }

                if (sum==100) {
                    pass[0] = i;
                    pass[1] = j;

                    break;
                }
            }
        }

        for (int i=0; i<9; i++) {
            if (i!=pass[0] && i!=pass[1])
                bwWriteIntToStr(talls[i], bw);
        }



        bw.close();
        br.close();
    }

    static void bwWriteIntToStr(int i, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(i));
        bw.newLine();
    }

}
