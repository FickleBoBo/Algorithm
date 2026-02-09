package day_03.boj_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isPossible = true;

            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPossible = false;
            }

            if (isPossible) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }
}
