package day_12.boj_1021;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (dq.peekFirst() == x) {
                    pos = i;
                }
                dq.offerLast(dq.pollFirst());
            }

            if (pos <= n / 2) {
                cnt += pos;
                for (int i = 0; i < pos; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                dq.pollFirst();
            } else {
                cnt += n - pos;
                for (int i = 0; i < n - pos; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                dq.pollFirst();
            }
            n--;
        }

        System.out.println(cnt);
    }
}
