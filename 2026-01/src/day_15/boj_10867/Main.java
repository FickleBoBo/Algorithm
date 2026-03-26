package day_15.boj_10867;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static boolean[] vis = new boolean[MAX + 1 + MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            vis[MAX + x] = true;
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) {
                sb.append(i - MAX).append(" ");
            }
        }

        System.out.println(sb);
    }
}
