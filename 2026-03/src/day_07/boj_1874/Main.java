package day_07.boj_1874;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 1;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            while (cur <= x) {
                stack.push(cur++);
                sb.append("+\n");
            }

            if (stack.peek() != x) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
