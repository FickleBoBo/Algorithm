package day_17.boj_14428;

import java.io.*;
import java.util.*;

public class Main2 {

    static class SegmentTree {
        int n;
        int[] tree;
        int[] arr;

        public SegmentTree(int[] arr) {
            this.n = arr.length - 1;
            this.tree = new int[4 * n];
            this.arr = arr;
            init(arr, 1, 1, n);
        }

        void init(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = start;
                return;
            }

            int mid = (start + end) / 2;

            init(arr, node * 2, start, mid);
            init(arr, node * 2 + 1, mid + 1, end);

            if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }
        }

        void update(int idx, int value) {
            update(1, 1, n, idx, value);
        }

        void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = idx;
                arr[idx] = value;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, value);
            }

            if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }
        }

        int query(int left, int right) {
            return query(1, 1, n, left, right);
        }

        int query(int node, int start, int end, int left, int right) {
            if (right < start || left > end) return -1;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;

            int leftMin = query(node * 2, start, mid, left, right);
            int rightMin = query(node * 2 + 1, mid + 1, end, left, right);

            if (leftMin == -1) {
                return rightMin;
            } else if (rightMin == -1) {
                return leftMin;
            } else {
                if (arr[leftMin] <= arr[rightMin]) {
                    return leftMin;
                } else {
                    return rightMin;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 1) {
                tree.update(a, b);
            } else {
                sb.append(tree.query(a, b)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
