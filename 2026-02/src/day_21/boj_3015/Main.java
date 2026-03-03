package day_21.boj_3015;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<int[]> stack = new ArrayDeque<>();
        long ans = 0;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int cnt = 1;

            while (!stack.isEmpty() && stack.peek()[0] < x) {
                ans += stack.pop()[1];
            }

            if (!stack.isEmpty() && stack.peek()[0] == x) {
                int[] top = stack.pop();
                ans += top[1];
                cnt += top[1];
            }

            if (!stack.isEmpty()) ans++;

            stack.push(new int[]{x, cnt});
        }

        System.out.println(ans);
    }
}
