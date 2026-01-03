package day_03.boj_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean isPossible = true;

            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }

                    if (stack.peek() == '(' && c == ')' || stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPossible = false;
            }

            if (isPossible) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }
}
