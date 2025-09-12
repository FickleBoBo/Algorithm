package day_13.prms_159993;

import java.util.*;

class Solution {

    // 상우하좌 방향 배열
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];

        // 주어진 maps를 2차원 char 배열로 변환하고 시작 지점, 출구, 레버의 위치 저장
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }

                map[i][j] = c;
            }
        }

        int answer = 0;

        // 시작 지점에서 레버까지 bfs 탐색으로 이동 가능한지 판단
        int startToLever = bfs(start, lever, map.length, map[0].length, map);
        if (startToLever == -1) return -1;
        answer += startToLever;

        // 레버에서 출구까지 bfs 탐색으로 이동 가능한지 판단
        int leverToEnd = bfs(lever, end, map.length, map[0].length, map);
        if (leverToEnd == -1) return -1;
        answer += leverToEnd;

        return answer;
    }

    private static int bfs(int[] from, int[] to, int N, int M, char[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(from);

        boolean[][] visited = new boolean[N][M];
        visited[from[0]][from[1]] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] node = q.poll();

                if (node[0] == to[0] && node[1] == to[1]) return dist;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] == 'X' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
