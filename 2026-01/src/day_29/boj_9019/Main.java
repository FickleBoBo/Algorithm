package day_29.boj_9019;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            String result = bfs(A, B);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs(int A, int B) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(A);

        boolean[] visited = new boolean[10000];
        visited[A] = true;

        int[] prev = new int[10000];
        Arrays.fill(prev, -1);
        char[] type = new char[10000];

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == B) {
                StringBuilder sb = new StringBuilder();

                while (prev[node] != -1) {
                    sb.append(type[node]);
                    node = prev[node];
                }

                return sb.reverse().toString();
            }

            int d1 = node * 2 % 10000;
            if (!visited[d1]) {
                q.offer(d1);
                visited[d1] = true;
                prev[d1] = node;
                type[d1] = 'D';
            }

            int d2 = (node - 1 + 10000) % 10000;
            if (!visited[d2]) {
                q.offer(d2);
                visited[d2] = true;
                prev[d2] = node;
                type[d2] = 'S';
            }

            int d3 = node % 1000 * 10 + node / 1000;
            if (!visited[d3]) {
                q.offer(d3);
                visited[d3] = true;
                prev[d3] = node;
                type[d3] = 'L';
            }

            int d4 = node % 10 * 1000 + node / 10;
            if (!visited[d4]) {
                q.offer(d4);
                visited[d4] = true;
                prev[d4] = node;
                type[d4] = 'R';
            }
        }

        return null;
    }
}
