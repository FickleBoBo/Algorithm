package day_01.boj_28278;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] stack = new int[1000000];
        int peek = -1;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack[++peek] = x;
            } else if (command == 2) {
                if (peek == -1) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack[peek--]).append("\n");
                }
            } else if (command == 3) {
                sb.append(peek + 1).append("\n");
            } else if (command == 4) {
                if (peek == -1) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                if (peek == -1) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack[peek]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
