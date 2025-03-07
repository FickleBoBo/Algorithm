package day_11.BOJ_6603;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int[] arr;
    private static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sel = new int[6];

            combination(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void combination(int idx, int selIdx) {
        if (selIdx == sel.length) {
            for (int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[selIdx] = arr[i];
            combination(i + 1, selIdx + 1);
        }
    }

}
