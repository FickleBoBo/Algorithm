package day_17.boj_14428;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000_001;

    static class Node {
        int min;
        int idx;

        public Node(int min, int idx) {
            this.min = min;
            this.idx = idx;
        }
    }

    static int[] arr;
    static Node[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], start);
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node merge(Node a, Node b) {
        if (a.min <= b.min) return new Node(a.min, a.idx);
        return new Node(b.min, b.idx);
    }

    static void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = new Node(value, idx);
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, value);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return new Node(MAX, 0);
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        Node leftRes = query(node * 2, start, mid, left, right);
        Node rightRes = query(node * 2 + 1, mid + 1, end, left, right);
        return merge(leftRes, rightRes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new Node[4 * n];
        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 1) {
                update(1, 1, n, a, b);
            } else {
                sb.append(query(1, 1, n, a, b).idx).append("\n");
            }
        }

        System.out.println(sb);
    }
}
