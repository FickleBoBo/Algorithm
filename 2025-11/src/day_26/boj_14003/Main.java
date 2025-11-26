package day_26.boj_14003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + N];
        dp[0] = Integer.MIN_VALUE;
        int len = 0;

        int[] before = new int[N];

        for (int i = 0; i < N; i++) {
            int idx = lowerBound(dp, len, arr[i]);

            dp[idx] = arr[i];
            if (idx == len + 1) len++;

            before[i] = idx;
        }

        sb.append(len).append('\n');

        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = len;
        for (int i = N - 1; i >= 0; i--) {
            if (before[i] == tmp) {
                stack.push(arr[i]);
                tmp--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int lowerBound(int[] arr, int len, int key) {
        int left = 1;
        int right = len + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
