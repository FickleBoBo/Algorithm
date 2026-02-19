package day_13.boj_1275;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static long[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
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
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long querySum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        long leftSum = querySum(node * 2, start, mid, left, right);
        long rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new long[4 * n];
        init(1, 1, n);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(querySum(1, 1, n, Math.min(x, y), Math.max(x, y))).append("\n");
            update(1, 1, n, a, b);
        }

        System.out.println(sb);
    }
}
