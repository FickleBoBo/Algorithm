package day_17.boj_12899;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MAX = 2_000_000;

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
            int bit = 1 << 21;

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
            int T = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (T == 1) {
                tree.update(X, 1);
            } else {
                int k = tree.kth(X);
                sb.append(k).append("\n");
                tree.update(k, -1);
            }
        }

        System.out.println(sb);
    }
}
