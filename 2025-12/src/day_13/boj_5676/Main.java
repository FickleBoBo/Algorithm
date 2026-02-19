package day_13.boj_5676;

import java.io.*;
import java.util.*;

public class Main {

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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    static int queryMul(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftMul = queryMul(node * 2, start, mid, left, right);
        int rightMul = queryMul(node * 2 + 1, mid + 1, end, left, right);
        return leftMul * rightMul;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[1 + n];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.signum(Integer.parseInt(st.nextToken()));
            }

            tree = new int[4 * n];
            init(1, 1, n);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (order.equals("C")) {
                    update(1, 1, n, a, Integer.signum(b));
                } else {
                    int result = queryMul(1, 1, n, a, b);

                    if (result > 0) {
                        sb.append("+");
                    } else if (result < 0) {
                        sb.append("-");
                    } else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
