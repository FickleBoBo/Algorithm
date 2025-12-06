package day_06.boj_10989;

import java.io.*;

public class Main {

    static final int MAX = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] cntArr = new int[1 + MAX];
        for (int i = 0; i < N; i++) {
            cntArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= cntArr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
