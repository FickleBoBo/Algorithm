package day_06.boj_17298;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];

            while (!stack.isEmpty() && stack.peek() <= x) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(x);
        }

        for (int x : res) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
