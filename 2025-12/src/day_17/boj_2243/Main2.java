package day_17.boj_2243;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MAX = 1_000_000;

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

        int kth(int k) {
            int pos = 0;
            int bit = 1 << 20;

            while (bit > 0) {
                int next = pos + bit;
                if (next <= n && tree[next] < k) {
                    k -= tree[next];
                    pos = next;
                }
                bit >>= 1;
            }

            return pos + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        FenwickTree tree = new FenwickTree(MAX);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 1) {
                int k = tree.kth(B);
                sb.append(k).append("\n");
                tree.update(k, -1);
            } else {
                int C = Integer.parseInt(st.nextToken());
                tree.update(B, C);
            }
        }

        System.out.println(sb);
    }
}
