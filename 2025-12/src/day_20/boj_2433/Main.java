package day_20.boj_2433;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> minDq = new ArrayDeque<>();  // 단조 증가 덱
        Deque<Integer> maxDq = new ArrayDeque<>();  // 단조 감소 덱
        for (int i = 1; i <= n; i++) {
            // 구간에서 나가는 인덱스 처리
            if (!minDq.isEmpty() && minDq.peekFirst() == (i - m)) {
                minDq.pollFirst();
            }

            // 구간으로 들어오는 인덱스 처리
            while (!minDq.isEmpty() && arr[i] <= arr[minDq.peekLast()]) {
                minDq.pollLast();
            }
            minDq.offerLast(i);

            // 구간에서 나가는 인덱스 처리
            if (!maxDq.isEmpty() && maxDq.peekFirst() == (i - m)) {
                maxDq.pollFirst();
            }

            // 구간으로 들어오는 인덱스 처리
            while (!maxDq.isEmpty() && arr[i] >= arr[maxDq.peekLast()]) {
                maxDq.pollLast();
            }
            maxDq.offerLast(i);

            // 윈도우 크기가 확보됐을 때부터 비교
            if ((i > m - 1) && (arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] <= c)) {
                sb.append(i - m + 1).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println("NONE");
        } else {
            System.out.println(sb);
        }
    }
}
