package day_20.boj_2433;

import java.io.*;
import java.util.*;

public class Main2 {

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

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

        PriorityQueue<Node> minPq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.value != o2.value) return Integer.compare(o1.value, o2.value);
            return Integer.compare(o1.idx, o2.idx);
        }));
        PriorityQueue<Node> maxPq = new PriorityQueue<>((o1, o2) -> {
            if (o1.value != o2.value) return Integer.compare(o2.value, o1.value);
            return Integer.compare(o1.idx, o2.idx);
        });
        for (int i = 1; i <= n; i++) {
            while (!minPq.isEmpty() && minPq.peek().idx <= (i - m)) {
                minPq.poll();
            }
            minPq.offer(new Node(arr[i], i));

            while (!maxPq.isEmpty() && maxPq.peek().idx <= (i - m)) {
                maxPq.poll();
            }
            maxPq.offer(new Node(arr[i], i));

            // 윈도우 크기가 확보됐을 때부터 비교
            if ((i > m - 1) && (maxPq.peek().value - minPq.peek().value <= c)) {
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
