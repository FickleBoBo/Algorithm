package day_16.boj_11003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 단조 덱
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            // 구간에서 나가는 인덱스 처리
            if (!dq.isEmpty() && dq.peekFirst() == (i - L)) {
                dq.pollFirst();
            }

            // 구간으로 들어오는 인덱스 처리
            while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
