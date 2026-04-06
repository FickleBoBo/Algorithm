package day_19.boj_2457;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            if (em < 3 || sm == 12) continue;
            pq.offer(new int[]{sm * 100 + sd, em * 100 + ed});
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        int last = 301;
        int cnt = 0;
        while (last < 1201) {
            boolean flag = true;
            while (!pq.isEmpty() && pq.peek()[0] <= last) {
                pq2.offer(pq.poll()[1]);
                flag = false;
            }

            if (flag) {
                System.out.println(0);
                return;
            }

            last = pq2.poll();
            cnt++;
        }

        System.out.println(cnt);
    }
}
