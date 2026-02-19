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

    static int[] arr;
    static Node[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], arr[start]);
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node merge(Node a, Node b) {
        return new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
    }

    static Node query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return new Node(MAX, MIN);
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        Node leftRes = query(node * 2, start, mid, left, right);
        Node rightRes = query(node * 2 + 1, mid + 1, end, left, right);
        return merge(leftRes, rightRes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new Node[4 * n];
        init(1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node result = query(1, 1, n, a, b);
            sb.append(result.min).append(" ").append(result.max).append("\n");
        }

        System.out.println(sb);
    }
}
