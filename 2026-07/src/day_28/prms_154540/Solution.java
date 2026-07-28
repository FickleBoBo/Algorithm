package day_28.prms_154540;

import java.util.*;

class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] vis = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X' || vis[i][j]) continue;

                int res = bfs(i, j, n, m, maps, vis);
                list.add(res);
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);

        return ans;
    }

    static int bfs(int sr, int sc, int n, int m, String[] maps, boolean[][] vis) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        vis[sr][sc] = true;

        int res = maps[sr].charAt(sc) - '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maps[nr].charAt(nc) == 'X' || vis[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
                res += maps[nr].charAt(nc) - '0';
            }
        }

        return res;
    }
}
