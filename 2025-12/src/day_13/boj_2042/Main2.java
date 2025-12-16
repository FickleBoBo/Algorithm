package day_13.boj_2042;

import java.io.*;
import java.util.*;

public class Main2 {

    static class FenwickTree {
        int n;
        long[] tree;

        public FenwickTree(int n) {
            this.n = n;
            tree = new long[1 + n];
        }

        void update(int idx, long delta) {
            while (idx <= n) {
                tree[idx] += delta;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }

        long sum(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[1 + N];
        FenwickTree tree = new FenwickTree(N);

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            tree.update(i, arr[i]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                tree.update(b, c - arr[b]);
                arr[b] = c;
            } else {
                sb.append(tree.sum(b, (int) c)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
