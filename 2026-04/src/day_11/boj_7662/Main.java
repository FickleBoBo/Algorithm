package day_11.boj_7662;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
            PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
            boolean[] chk = new boolean[1000000];

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char q = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());

                if (q == 'I') {
                    pq.offer(new int[]{i, x});
                    pq2.offer(new int[]{i, x});
                } else {
                    if (x == 1) {
                        while (!pq2.isEmpty() && chk[pq2.peek()[0]]) {
                            pq2.poll();
                        }

                        if (!pq2.isEmpty()) {
                            chk[pq2.poll()[0]] = true;
                        }
                    } else {
                        while (!pq.isEmpty() && chk[pq.peek()[0]]) {
                            pq.poll();
                        }

                        if (!pq.isEmpty()) {
                            chk[pq.poll()[0]] = true;
                        }
                    }
                }
            }

            while (!pq.isEmpty() && chk[pq.peek()[0]]) {
                pq.poll();
            }
            while (!pq2.isEmpty() && chk[pq2.peek()[0]]) {
                pq2.poll();
            }

            if (pq.isEmpty() || pq2.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(pq2.peek()[1]).append(" ").append(pq.peek()[1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
