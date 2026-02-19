package day_15.boj_10867;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] visited = new boolean[MAX + 1 + MAX];

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            visited[MAX + x] = true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(i - MAX).append(" ");
            }
        }

        System.out.println(sb);
    }
}
