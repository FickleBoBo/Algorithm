package day_17.boj_15903;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(x + y);
            pq.offer(x + y);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}
