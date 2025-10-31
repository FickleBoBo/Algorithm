package day_31.boj_1427;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("");
        int[] cntArr = new int[10];  // 카운팅 배열

        for (String n : input) {
            cntArr[Integer.parseInt(n)]++;
        }

        // 내림차순으로 저장
        for (int i = 9; i >= 0; i--) {
            sb.append(String.valueOf(i).repeat(cntArr[i]));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
