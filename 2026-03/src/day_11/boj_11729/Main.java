package day_11.boj_11729;

import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dfs(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void dfs(int n, int from, int by, int to) {
        if (n == 0) return;

        dfs(n - 1, from, to, by);

        sb.append(from).append(" ").append(to).append("\n");
        cnt++;

        dfs(n - 1, by, from, to);
    }
}
