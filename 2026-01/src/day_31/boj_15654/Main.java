package day_31.boj_15654;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sel = new int[m];
        visited = new boolean[n];

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

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            sel[selIdx] = arr[i];
            visited[i] = true;
            dfs(selIdx + 1);
            visited[i] = false;
        }
    }
}
