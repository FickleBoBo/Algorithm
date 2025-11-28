package day_26.boj_2568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] dp = new int[1 + N];
        int len = 0;

        int[] prev = new int[N];

        for (int i = 0; i < N; i++) {
            int idx = lowerBound(dp, len, map[i][1]);

            dp[idx] = map[i][1];
            if (idx == len + 1) len++;

            prev[i] = idx;
        }

        sb.append(N - len).append('\n');

        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = len;
        for (int i = N - 1; i >= 0; i--) {
            if (prev[i] == tmp) {
                tmp--;
            } else {
                stack.push(map[i][0]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append('\n');
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
