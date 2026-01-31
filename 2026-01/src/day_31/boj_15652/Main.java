package day_31.boj_15652;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int idx, int selIdx) {
        if (selIdx == M) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
            sel[selIdx] = i;
            dfs(i, selIdx + 1);
        }
    }
}
