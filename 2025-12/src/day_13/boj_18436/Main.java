package day_13.boj_18436;

import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int[] arr) {
            this.n = arr.length - 1;
            this.tree = new int[4 * n];
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
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
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
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        int querySum(int left, int right) {
            return querySum(1, 1, n, left, right);
        }

        int querySum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;

            int leftSum = querySum(node * 2, start, mid, left, right);
            int rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2;
        }

        SegmentTree tree = new SegmentTree(arr);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 1) {
                tree.update(a, b % 2);
            } else if (t == 2) {
                sb.append((b - a + 1) - tree.querySum(a, b)).append("\n");
            } else {
                sb.append(tree.querySum(a, b)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
