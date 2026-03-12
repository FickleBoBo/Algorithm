package day_09.boj_10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;

        String s = br.readLine();
        char prv = '\u0000';

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (prv == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    stack.pop();
                    cnt++;
                }
            }

            prv = c;
        }

        System.out.println(cnt);
    }
}
