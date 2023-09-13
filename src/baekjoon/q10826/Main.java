package baekjoon.q10826;

import java.io.*;
import java.util.ArrayList;

public class Main {

    // KB       ms      B
    // 21236	208	    2027

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> stackList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            stack(br.readLine());
        }


        bw.close();
        br.close();

    }


    static void stack(String command) throws IOException {

        int lastIdx = stackList.size() - 1;

        switch (command.substring(0, 2)) {
            case "pu": //push
                String[] addCmd = command.split(" ");
                stackList.add(Integer.parseInt(addCmd[1]));

                break;


            case "po": //pop
                if (stackList.isEmpty()) {
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                } else {
                    int lastNum = stackList.remove(lastIdx);
                    bw.write(String.valueOf(lastNum));
                    bw.newLine();
                }
                break;


            case "si": //size
                int stackSize = stackList.size();
                bw.write(String.valueOf(stackSize));
                bw.newLine();

                break;


            case "em": //empty
                int checkEmpty = stackList.size() == 0 ? 1 : 0;
                bw.write(String.valueOf(checkEmpty));
                bw.newLine();

                break;

            case "to": //top
                if (stackList.isEmpty()) {
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                } else {
                    int lastNum = stackList.get(lastIdx);
                    bw.write(String.valueOf(lastNum));
                    bw.newLine();
                }

                break;
        }
    }
}
