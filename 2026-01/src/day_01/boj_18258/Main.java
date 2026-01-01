package day_01.boj_18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] queue = new int[2000000];
        int front = 0;
        int rear = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue[rear++] = x;
            } else if (command.equals("pop")) {
                if (front == rear) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue[front++]).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(rear - front).append("\n");
            } else if (command.equals("empty")) {
                if (front == rear) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("front")) {
                if (front == rear) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue[front]).append("\n");
                }
            } else {
                if (front == rear) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue[rear - 1]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
