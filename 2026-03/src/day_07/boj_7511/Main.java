package day_07.boj_7511;

import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    static void make(int n) {
        p = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = i;
        }
    }

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            make(n);

            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            sb.append("Scenario ").append(tc).append(":\n");
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (find(u) == find(v)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
