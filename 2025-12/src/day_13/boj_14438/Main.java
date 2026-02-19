package day_13.boj_14438;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000_000;

    static int[] arr;
    static int[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static void update(int node, int start, int end, int idx, int value) {
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
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int queryMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return MAX;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftMin = queryMin(node * 2, start, mid, left, right);
        int rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(leftMin, rightMin);
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

        tree = new int[4 * n];
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
                sb.append(queryMin(1, 1, n, a, b)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
