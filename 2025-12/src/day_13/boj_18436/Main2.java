package day_13.boj_18436;

import java.io.*;
import java.util.*;

public class Main2 {

    static class FenwickTree {
        int n;
        int[] tree;

        public FenwickTree(int n) {
            this.n = n;
            tree = new int[1 + n];
        }

        void update(int idx, int delta) {
            while (idx <= n) {
                tree[idx] += delta;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int res = 0;
            while (idx > 0) {
                res += tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }

        int sum(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1 + N];
        FenwickTree tree = new FenwickTree(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2;
            tree.update(i, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 1) {
                tree.update(a, b % 2 - arr[a]);
                arr[a] = b % 2;
            } else if (t == 2) {
                sb.append((b - a + 1) - tree.sum(a, b)).append("\n");
            } else {
                sb.append(tree.sum(a, b)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
