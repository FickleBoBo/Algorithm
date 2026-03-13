package day_15.boj_10867;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] vis = new boolean[MX + 1 + MX];

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            vis[MX + x] = true;
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) {
                sb.append(i - MX).append(" ");
            }
        }

        System.out.println(sb);
    }
}
