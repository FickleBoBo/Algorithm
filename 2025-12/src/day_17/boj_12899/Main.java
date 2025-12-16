package day_17.boj_12899;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 2_000_000;

    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
        }

        void update(int idx, int delta) {
            update(1, 1, n, idx, delta);
        }

        void update(int node, int start, int end, int idx, int delta) {
            if (start == end) {
                tree[node] += delta;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, delta);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, delta);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        int queryKth(int k) {
            return queryKth(1, 1, n, k);
        }

        int queryKth(int node, int start, int end, int k) {
            if (start == end) return start;

            int mid = (start + end) / 2;

            if (k <= tree[node * 2]) {
                return queryKth(node * 2, start, mid, k);
            } else {
                return queryKth(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        SegmentTree tree = new SegmentTree(MAX);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (T == 1) {
                tree.update(X, 1);
            } else {
                int k = tree.queryKth(X);
                sb.append(k).append("\n");
                tree.update(k, -1);
            }
        }

        System.out.println(sb);
    }
}
