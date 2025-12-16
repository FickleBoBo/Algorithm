package day_13.boj_11505;

import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    static class SegmentTree {
        int n;
        long[] tree;

        public SegmentTree(int[] arr) {
            this.n = arr.length - 1;
            this.tree = new long[4 * n];
            init(arr, 1, 1, n);
        }

        void init(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            init(arr, node * 2, start, mid);
            init(arr, node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
        }

        void update(int idx, int value) {
            update(1, 1, n, idx, value);
        }

        void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, value);
            }
            tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
        }

        long queryMul(int left, int right) {
            return queryMul(1, 1, n, left, right);
        }

        long queryMul(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;

            long leftMul = queryMul(node * 2, start, mid, left, right);
            long rightMul = queryMul(node * 2 + 1, mid + 1, end, left, right);
            return leftMul * rightMul % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(arr);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                tree.update(b, c);
            } else {
                sb.append(tree.queryMul(b, c)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
