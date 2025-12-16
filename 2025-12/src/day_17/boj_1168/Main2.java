package day_17.boj_1168;

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

        int kth(int k) {
            int pos = 0;
            int bit = 1 << 17;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        FenwickTree tree = new FenwickTree(N);
        for (int i = 1; i <= N; i++) {
            tree.update(i, 1);
        }
        int alive = N;
        int cur = 0;

        sb.append("<");
        for (int i = 0; i < N; i++) {
            cur = (cur + K - 1) % alive;

            int idx = tree.kth(cur + 1);
            tree.update(idx, -1);
            alive--;

            sb.append(idx);
            if (i != N - 1) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}
