package day_13.boj_2268;

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

        void modify(int idx, long delta) {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        FenwickTree tree = new FenwickTree(N);
        long[] arr = new long[1 + N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                sb.append(tree.sum(Math.min(a, b), Math.max(a, b))).append("\n");
            } else {
                tree.modify(a, b - arr[a]);
                arr[a] = b;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
