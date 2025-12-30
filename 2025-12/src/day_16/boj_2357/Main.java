package day_16.boj_2357;

import java.io.*;
import java.util.*;

public class Main {

    static final int MIN = 1;
    static final int MAX = 1_000_000_000;

    static class Node {
        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static class SegmentTree {
        int n;
        Node[] tree;

        public SegmentTree(int[] arr) {
            this.n = arr.length - 1;
            this.tree = new Node[4 * n];
            init(arr, 1, 1, n);
        }

        void init(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = new Node(arr[start], arr[start]);
                return;
            }

            int mid = (start + end) / 2;

            init(arr, node * 2, start, mid);
            init(arr, node * 2 + 1, mid + 1, end);
            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        Node merge(Node a, Node b) {
            return new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
        }

        String query(int left, int right) {
            Node res = query(1, 1, n, left, right);
            return res.min + " " + res.max;
        }

        Node query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return new Node(MAX, MIN);
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;

            Node leftRes = query(node * 2, start, mid, left, right);
            Node rightRes = query(node * 2 + 1, mid + 1, end, left, right);
            return merge(leftRes, rightRes);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(arr);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(tree.query(a, b)).append("\n");
        }

        System.out.println(sb);
    }
}
