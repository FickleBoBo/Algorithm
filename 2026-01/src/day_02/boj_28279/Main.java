package day_02.boj_28279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] deque = new int[2000000];
        int front = 1000000;
        int back = 1000000;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                deque[--front] = x;
            } else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                deque[back++] = x;
            } else if (command == 3) {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[front++]).append("\n");
                }
            } else if (command == 4) {
                if (front == back) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[--back]).append("\n");
                }
            } else if (command == 5) {
                sb.append(back - front).append("\n");
            } else if (command == 6) {
                if (front == back) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command == 7) {
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
