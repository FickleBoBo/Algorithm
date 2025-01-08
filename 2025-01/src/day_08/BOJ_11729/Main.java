package day_08.BOJ_11729;

import java.io.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dfs(N, 1, 2, 3);

        bw.write(Integer.toString(cnt));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int N, int from, int mid, int to) {
        if (N == 0) return;

        dfs(N - 1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;
        dfs(N - 1, mid, from, to);
    }

}
