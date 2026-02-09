package day_04.boj_24511;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean[] isQueue = new boolean[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int flag = Integer.parseInt(st.nextToken());
            if (flag == 0) {
                isQueue[i] = true;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (isQueue[i]) {
                dq.offerLast(x);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            dq.offerFirst(x);

            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
