package day_29.boj_1963;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] isPrime = sieve(10_000);

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int dist = bfs(A, B, isPrime);
            if (dist == -1) {
                sb.append("Impossible\n");
            } else {
                sb.append(dist).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 에라토스테네스의 체
    private static boolean[] sieve(int N) {
        boolean[] isPrime = new boolean[1 + N];
        Arrays.fill(isPrime, 2, N + 1, true);

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    private static int bfs(int A, int B, boolean[] isPrime) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(A);

        boolean[] visited = new boolean[10_000];
        visited[A] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == B) return dist;

                for (int j = 0; j < 10; j++) {
                    int num1 = node / 10 * 10 + j;  // 일의 자리 변경
                    int num2 = node / 100 * 100 + j * 10 + node % 10;  // 십의 자리 변경
                    int num3 = node / 1000 * 1000 + j * 100 + node % 100;  // 백의 자리 변경
                    int num4 = j * 1000 + node % 1000;  // 천의 자리 변경

                    if (isPrime[num1] && !visited[num1]) {
                        q.offer(num1);
                        visited[num1] = true;
                    }

                    if (isPrime[num2] && !visited[num2]) {
                        q.offer(num2);
                        visited[num2] = true;
                    }

                    if (isPrime[num3] && !visited[num3]) {
                        q.offer(num3);
                        visited[num3] = true;
                    }

                    if (num4 >= 1_000 && isPrime[num4] && !visited[num4]) {
                        q.offer(num4);
                        visited[num4] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }
}
