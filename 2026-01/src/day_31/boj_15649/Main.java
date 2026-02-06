package day_31.boj_15649;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sel = new int[m];
        visited = new boolean[1 + n];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int selIdx) {
        if (selIdx == m) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            sel[selIdx] = i;
            visited[i] = true;
            dfs(selIdx + 1);
            visited[i] = false;
        }
    }
}
