package day_05.boj_2346;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            dq.offerLast(new int[]{i, x});
        }

        while (true) {
            int[] balloon = dq.pollFirst();

            sb.append(balloon[0]).append(" ");

            if (dq.isEmpty()) break;

            int x = balloon[1];
            if (x > 0) {
                for (int i = 1; i < x; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (int i = 1; i <= -x; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}
