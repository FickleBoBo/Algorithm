package day_09.boj_1963;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 9999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] isPrime = sieve();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dist = bfs(a, b, isPrime);
            if (dist == -1) {
                sb.append("Impossible\n");
            } else {
                sb.append(dist).append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean[] sieve() {
        boolean[] isPrime = new boolean[1 + MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    static int bfs(int a, int b, boolean[] isPrime) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);

        boolean[] vis = new boolean[1 + MAX];
        vis[a] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == b) return dist;

                for (int i = 0; i < 10; i++) {
                    int num1 = cur / 10 * 10 + i;  // 일의 자리 변경
                    int num2 = cur / 100 * 100 + i * 10 + cur % 10;  // 십의 자리 변경
                    int num3 = cur / 1000 * 1000 + i * 100 + cur % 100;  // 백의 자리 변경
                    int num4 = i * 1000 + cur % 1000;  // 천의 자리 변경

                    if (isPrime[num1] && !vis[num1]) {
                        q.offer(num1);
                        vis[num1] = true;
                    }

                    if (isPrime[num2] && !vis[num2]) {
                        q.offer(num2);
                        vis[num2] = true;
                    }

                    if (isPrime[num3] && !vis[num3]) {
                        q.offer(num3);
                        vis[num3] = true;
                    }

                    if (num4 >= 1000 && isPrime[num4] && !vis[num4]) {
                        q.offer(num4);
                        vis[num4] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }
}
