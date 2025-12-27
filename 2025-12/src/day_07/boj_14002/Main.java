package day_07.boj_14002;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] prev = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int max = 0;
        int pos = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                pos = i;
            }
        }

        System.out.println(max);
        System.out.println(traceback(arr, prev, pos));
    }

    static String traceback(int[] arr, int[] prev, int pos) {
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();
        while (pos != -1) {
            stack.push(arr[pos]);
            pos = prev[pos];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }
}
