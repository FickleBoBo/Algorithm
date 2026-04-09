package day_29.prms_154540;

import java.util.*;

class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        int[][] map = init(maps);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) continue;

                int res = bfs(i, j, map.length, map[i].length, map);
                list.add(res);
            }
        }
        list.sort(Comparator.naturalOrder());

        if (list.isEmpty()) {
            return new int[]{-1};
        }
        return listToArr(list);
    }

    static int[][] init(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c != 'X') map[i][j] = c - '0';
            }
        }

        return map;
    }

    static int bfs(int sr, int sc, int n, int m, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        int sum = map[sr][sc];
        map[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc});
                sum += map[nr][nc];
                map[nr][nc] = 0;
            }
        }

        return sum;
    }

    static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
