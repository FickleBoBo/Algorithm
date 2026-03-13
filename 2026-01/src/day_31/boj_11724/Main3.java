package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] p;

    static void make(int n) {
        p = new int[1 + n];
        for (int i = 1; i <= n; i++) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        make(n);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int cnt = 0;
        for (int cur = 1; cur <= n; cur++) {
            if (cur == find(cur)) cnt++;
        }

        System.out.println(cnt);
    }
}
