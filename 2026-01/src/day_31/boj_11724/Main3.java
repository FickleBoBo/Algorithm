package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] p;

    static int[] make(int N) {
        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) {
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = make(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int cnt = 0;
        for (int node = 1; node <= N; node++) {
            if (node == find(node)) cnt++;
        }

        System.out.println(cnt);
    }
}
