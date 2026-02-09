package day_08.boj_18115;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) {
                dq.offerFirst(i);
            } else if (x == 2) {
                int tmp = dq.pollFirst();
                dq.offerFirst(i);
                dq.offerFirst(tmp);
            } else {
                dq.offerLast(i);
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
