package day_01.boj_28278;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1000000;
    static int[] stack = new int[MX];
    static int pos = 0;

    static void push(int x) {
        stack[pos++] = x;
    }

    static int pop() {
        return stack[--pos];
    }

    static int size() {
        return pos;
    }

    static boolean empty() {
        return pos == 0;
    }

    static int top() {
        return stack[pos - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            if (c == 1) {
                int x = Integer.parseInt(st.nextToken());
                push(x);
            } else if (c == 2) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop()).append("\n");
                }
            } else if (c == 3) {
                sb.append(size()).append("\n");
            } else if (c == 4) {
                if (empty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(top()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
