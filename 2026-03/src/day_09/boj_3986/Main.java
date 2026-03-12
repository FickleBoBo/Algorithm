package day_09.boj_3986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();

            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
