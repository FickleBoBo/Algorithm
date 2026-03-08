package day_07.boj_2493;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[0] < x) {
                stack.pop();
            }

            sb.append(stack.isEmpty() ? 0 : stack.peek()[1]).append(" ");
            stack.push(new int[]{x, i});
        }

        System.out.println(sb);
    }
}
