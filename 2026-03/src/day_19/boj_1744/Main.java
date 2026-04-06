package day_19.boj_1744;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                pq.offer(x);
            } else {
                pq2.offer(x);
            }
        }

        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += Math.max(a * b, a + b);
        }
        if (!pq.isEmpty()) {
            sum += pq.poll();
        }

        while (pq2.size() > 1) {
            sum += pq2.poll() * pq2.poll();
        }
        if (!pq2.isEmpty()) {
            sum += pq2.poll();
        }

        System.out.println(sum);
    }
}
