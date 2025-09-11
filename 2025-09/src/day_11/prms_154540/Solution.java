package day_11.prms_154540;

import java.util.*;

class Solution {

    // 상우하좌 방향 배열
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        int[][] map = init(maps);  // 2차원 int 배열로 변환

        List<Integer> list = new ArrayList<>();  // 무인도별 머물 수 있는 날 임시 저장
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) continue;

                int result = bfs(i, j, map.length, map[i].length, map);
                list.add(result);
            }
        }
        list.sort(Comparator.naturalOrder());  // 오름차순 정렬

        if (list.isEmpty()) return new int[]{-1};  // 지낼 수 있는 무인도가 없으면 -1을 배열에 담아 반환
        return listToArray(list);  // list를 배열로 변환해서 반환
    }

    private static int[][] init(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);

                if (c != 'X') map[i][j] = Character.getNumericValue(c);
            }
        }

        return map;
    }

    // 원본 무인도를 변경하여 방문 체크(방문한 땅을 바다로 변환)
    private static int bfs(int r, int c, int N, int M, int[][] map) {
        int sum = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        sum += map[r][c];
        map[r][c] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc});
                sum += map[nr][nc];
                map[nr][nc] = 0;
            }
        }

        return sum;
    }

    private static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
