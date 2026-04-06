package day_19.boj_19598;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(0);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (pq.peek() <= arr[i][0]) pq.poll();
            pq.offer(arr[i][1]);

            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}
