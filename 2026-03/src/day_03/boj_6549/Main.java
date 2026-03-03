package day_03.boj_6549;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            Deque<int[]> stack = new ArrayDeque<>();
            long max = 0;

            for (int i = 0; i < n; i++) {
                int h = Integer.parseInt(st.nextToken());
                int idx = i;

                while (!stack.isEmpty() && stack.peek()[0] > h) {
                    max = Math.max(max, (long) (i - stack.peek()[1]) * stack.peek()[0]);
                    idx = stack.pop()[1];
                }

                stack.push(new int[]{h, idx});
            }

            while (!stack.isEmpty()) {
                max = Math.max(max, (long) (n - stack.peek()[1]) * stack.peek()[0]);
                stack.pop();
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
