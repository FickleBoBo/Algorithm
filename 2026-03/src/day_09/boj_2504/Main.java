package day_09.boj_2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();
        int sum = 0;
        int x = 1;

        String s = br.readLine();
        char prv = '\u0000';

        for (char c : s.toCharArray()) {
            if (c == '(') {
                x *= 2;
                stack.push(c);
            } else if (c == '[') {
                x *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (prv == '(') sum += x;
                x /= 2;
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (prv == '[') sum += x;
                x /= 3;
                stack.pop();
            }

            prv = c;
        }

        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}
