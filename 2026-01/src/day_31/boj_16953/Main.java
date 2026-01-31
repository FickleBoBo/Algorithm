package day_31.boj_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = bfs(A, B);
        System.out.println(result);
    }

    static int bfs(int A, int B) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(A);

        Set<Integer> visited = new HashSet<>();
        visited.add(A);

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == B) return dist;

                if (node * 2L <= B && !visited.contains(node * 2)) {
                    q.offer(node * 2);
                    visited.add(node * 2);
                }

                if (node * 10L + 1 <= B && !visited.contains(node * 10 + 1)) {
                    q.offer(node * 10 + 1);
                    visited.add(node * 10 + 1);
                }
            }

            dist++;
        }

        return -1;
    }
}
