package day_20.boj_11003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 단조 큐
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 구간에서 나가는 인덱스 처리
            if (!dq.isEmpty() && dq.peekFirst() == (i - l)) {
                dq.pollFirst();
            }

            // 구간으로 들어오는 인덱스 처리
            while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}
