package day_01.boj_10828;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] stack = new int[10000];
        int top = -1;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack[++top] = x;
            } else if (command.equals("pop")) {
                if (top == -1) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack[top--]).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(top + 1).append("\n");
            } else if (command.equals("empty")) {
                if (top == -1) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                if (top == -1) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack[top]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
