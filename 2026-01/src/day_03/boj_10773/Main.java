package day_03.boj_10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
