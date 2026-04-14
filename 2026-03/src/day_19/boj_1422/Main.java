package day_19.boj_1422;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String s : arr) {
            pq.offer(s);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) return Integer.compare(o2.length(), o1.length());
            return (o2 + o1).compareTo(o1 + o2);
        });

        for (int i = 0; i < k - n; i++) {
            pq.offer(arr[0]);
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb);
    }
}
