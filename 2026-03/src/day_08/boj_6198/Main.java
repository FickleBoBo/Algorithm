package day_08.boj_6198;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        long cnt = 0;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }

            cnt += stack.size();
            stack.push(h);
        }

        System.out.println(cnt);
    }
}
