package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] p;

    static int[] make(int n) {
        int[] arr = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static int find(int x) {
        if (x == p[x]) return x;
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

        p = make(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int cnt = 0;
        for (int node = 1; node <= n; node++) {
            if (node == find(node)) cnt++;
        }

        System.out.println(cnt);
    }
}
