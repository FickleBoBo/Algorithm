package day_17.boj_1168;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
            init(1, 1, n);
        }

        void init(int node, int start, int end) {
            if (start == end) {
                tree[node] = 1;
                return;
            }

            int mid = (start + end) / 2;

            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        void update(int idx) {
            update(1, 1, n, idx);
        }

        void update(int node, int start, int end, int idx) {
            if (start == end) {
                tree[node] = 0;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx);
            } else {
                update(node * 2 + 1, mid + 1, end, idx);
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        SegmentTree tree = new SegmentTree(N);
        int alive = N;
        int cur = 0;

        sb.append("<");
        for (int i = 0; i < N; i++) {
            cur = (cur + K - 1) % alive;

            int idx = tree.queryKth(cur + 1);
            tree.update(idx);
            alive--;

            sb.append(idx);
            if (i != N - 1) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}
