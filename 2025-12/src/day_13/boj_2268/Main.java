package day_13.boj_2268;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int n;
        long[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new long[4 * n];
        }

        void modify(int idx, int value) {
            modify(1, 1, n, idx, value);
        }

        void modify(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                modify(node * 2, start, mid, idx, value);
            } else {
                modify(node * 2 + 1, mid + 1, end, idx, value);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        long sum(int left, int right) {
            return sum(1, 1, n, left, right);
        }

        long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;

            long leftSum = sum(node * 2, start, mid, left, right);
            long rightSum = sum(node * 2 + 1, mid + 1, end, left, right);
            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SegmentTree tree = new SegmentTree(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                sb.append(tree.sum(Math.min(a, b), Math.max(a, b))).append("\n");
            } else {
                tree.modify(a, b);
            }
        }

        System.out.println(sb);
    }
}
