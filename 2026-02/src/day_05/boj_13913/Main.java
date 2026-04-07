package day_05.boj_13913;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    static String bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        boolean[] vis = new boolean[1 + MAX];
        vis[n] = true;

        int dist = 0;

        int[] prv = new int[1 + MAX];
        Arrays.fill(prv, -1);

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == k) return traceback(dist, k, prv);

                int nxt1 = cur - 1;
                if (nxt1 >= 0 && !vis[nxt1]) {
                    q.offer(nxt1);
                    vis[nxt1] = true;
                    prv[nxt1] = cur;
                }

                int nxt2 = cur + 1;
                if (nxt2 <= MAX && !vis[nxt2]) {
                    q.offer(nxt2);
                    vis[nxt2] = true;
                    prv[nxt2] = cur;
                }

                int nxt3 = cur * 2;
                if (nxt3 <= MAX && !vis[nxt3]) {
                    q.offer(nxt3);
                    vis[nxt3] = true;
                    prv[nxt3] = cur;
                }
            }

            dist++;
        }

        return null;
    }

    static String traceback(int dist, int k, int[] prv) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        sb.append(dist).append("\n");

        int pos = k;
        while (pos != -1) {
            stack.push(pos);
            pos = prv[pos];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }
}
