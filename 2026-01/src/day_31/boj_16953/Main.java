package day_31.boj_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static int bfs(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);

        Set<Integer> visited = new HashSet<>();
        visited.add(a);

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == b) return dist;

                if (node * 2L <= b && !visited.contains(node * 2)) {
                    q.offer(node * 2);
                    visited.add(node * 2);
                }

                if (node * 10L + 1 <= b && !visited.contains(node * 10 + 1)) {
                    q.offer(node * 10 + 1);
                    visited.add(node * 10 + 1);
                }
            }

            dist++;
        }

        return -1;
    }
}
