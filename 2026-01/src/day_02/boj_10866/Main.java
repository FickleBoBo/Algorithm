package day_02.boj_10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] deque = new int[20000];
        int front = 10000;
        int back = 10000;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque[--front] = x;
            } else if (command.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque[back++] = x;
            } else if (command.equals("pop_front")) {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[front++]).append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[--back]).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(back - front).append("\n");
            } else if (command.equals("empty")) {
                if (front == back) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("front")) {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[front]).append("\n");
                }
            } else {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[back - 1]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
