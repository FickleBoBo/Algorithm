package day_10.BOJ_17472;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private static int[] p;

    private static int[] make(int N) {
        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) arr[i] = i;
        return arr;
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 번호 붙이기
        boolean[][] visited = new boolean[N][M];
        int num = 1;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;

                bfs(i, j, num, N, M, map, visited);
                num++;
                cnt++;
            }
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        // 가로 방향 다리 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (map[i][j] != 0 && map[i][j + 1] == 0) {
                    int k = 1;
                    while (j + k < M && map[i][j + k] == 0) {
                        k++;
                    }
                    if (j + k != M && k > 2) edges.add(new Edge(map[i][j], map[i][j + k], k - 1));

                    // 탐색 위치 변경
                    j += k - 1;
                }
            }
        }

        // 세로 방향 다리 탐색
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] != 0 && map[i + 1][j] == 0) {
                    int k = 1;
                    while (i + k < N && map[i + k][j] == 0) {
                        k++;
                    }
                    if (i + k != N && k > 2) edges.add(new Edge(map[i][j], map[i + k][j], k - 1));

                    // 탐색 위치 변경
                    i += k - 1;
                }
            }
        }

        int ans = kruskal(cnt, edges);
        System.out.println(ans);
    }

    private static void bfs(int r, int c, int num, int N, int M, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] node = q.remove();
            map[node[0]][node[1]] = num;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    private static int kruskal(int N, PriorityQueue<Edge> edges) {
        p = make(N);

        int sum = 0;
        int cnt = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.remove();
            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            sum += e.w;
            cnt++;

            if (cnt == N - 1) return sum;
        }

        return -1;
    }

}
