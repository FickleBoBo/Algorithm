package day_20.boj_20136;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer>[] nxt = new ArrayDeque[1 + k];
        for (int i = 1; i <= k; i++) {
            nxt[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < k; i++) {
            nxt[arr[i]].offer(i);
        }
        for (int i = 1; i <= k; i++) {
            nxt[i].offer(INF);
        }

        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (set.size() < n) {
                nxt[arr[i]].poll();
                set.add(arr[i]);
                pq.offer(new int[]{nxt[arr[i]].peek(), arr[i]});
                continue;
            }
            if (set.contains(arr[i])) {
                nxt[arr[i]].poll();
                pq.offer(new int[]{nxt[arr[i]].peek(), arr[i]});
                continue;
            }

            int[] cur = pq.poll();

            set.remove(cur[1]);
            cnt++;

            nxt[arr[i]].poll();
            set.add(arr[i]);
            pq.offer(new int[]{nxt[arr[i]].peek(), arr[i]});
        }

        System.out.println(cnt);
    }
}
