package day_28.prms_154540;

import java.util.*;

class Solution2 {

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

                int res = dfs(i, j, n, m, maps, vis);
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

    static int dfs(int r, int c, int n, int m, String[] maps, boolean[][] vis) {
        vis[r][c] = true;
        int res = maps[r].charAt(c) - '0';

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (maps[nr].charAt(nc) == 'X' || vis[nr][nc]) continue;

            res += dfs(nr, nc, n, m, maps, vis);
        }

        return res;
    }
}
