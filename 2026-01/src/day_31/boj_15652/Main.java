package day_31.boj_15652;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sel = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int idx, int selIdx) {
        if (selIdx == m) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            sel[selIdx] = i;
            dfs(i, selIdx + 1);
        }
    }
}
