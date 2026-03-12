package day_03.boj_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (!stack.isEmpty() && (stack.peek() == '(' && c == ')' || stack.peek() == '[' && c == ']')) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }
}
