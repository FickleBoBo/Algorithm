package day_07.BOJ_1941;

import java.io.*;
import java.util.*;

public class Main {

    // 조합용 정적 변수
    private static final int[] sel = new int[7];
    private static int ans = 0;

    // BFS용 정적 변수
    private static char[] map = new char[25];
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // StringBuilder로 묶어서 입력을 1차원 배열로 처리
        for (int i = 0; i < 5; i++) {
            sb.append(br.readLine());
        }
        map = sb.toString().toCharArray();

        combination(0, 0);

        System.out.println(ans);
    }

    // 일반 조합 메서드
    private static void combination(int idx, int selIdx) {
        if (selIdx == sel.length) {
            // 이다솜파가 더 많음 && 7명이 가로세로로 인접해 있음
            if (check() && bfs(sel[0])) ans++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            sel[selIdx] = i;
            combination(i + 1, selIdx + 1);
        }
    }

    // 7명 중 이다솜파가 더 많으면 true
    private static boolean check() {
        int cnt = 0;
        for (int n : sel) {
            if (map[n] == 'S') cnt++;
        }
        return cnt > 3;
    }

    // 7명이 가로세로로 인접해있으면 true
    private static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[25];
        visited[start] = true;

        int cnt = 1;

        // Queue에 넣는건 방금 뽑은 7명만임
        Set<Integer> set = new HashSet<>();
        for (int n : sel) {
            set.add(n);
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node / 5 + dr[dir];
                int nc = node % 5 + dc[dir];
                int next = nr * 5 + nc;

                // map을 벗어나는건 따로 nr, nc로 비교해야함
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (visited[next]) continue;
                if (!set.contains(next)) continue;

                q.offer(next);
                visited[next] = true;
                cnt++;
            }
        }

        return cnt == 7;
    }

}
