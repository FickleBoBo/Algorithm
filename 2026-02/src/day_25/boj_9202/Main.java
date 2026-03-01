package day_25.boj_9202;

import java.io.*;

public class Main {

    static final int MX = 1 + 300000 * 8;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][26];
    static int[] chk = new int[MX];
    static int mark = 2;

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static char[][] grid = new char[4][4];
    static boolean[][] visited = new boolean[4][4];
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static int point;  // 최대 점수
    static String longest;  // 가장 긴 단어
    static int cnt;  // 찾은 단어의 개수

    static void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
            cur = nxt[cur][idx];
        }
        chk[cur] = 1;
    }

    static void find(int r, int c, int cur, StringBuilder word) {
        visited[r][c] = true;

        if (0 < chk[cur] && chk[cur] < mark) {
            chk[cur] = mark;

            point += score[word.length()];
            if (word.length() > longest.length() || (word.length() == longest.length() && word.toString().compareTo(longest) < 0)) {
                longest = word.toString();
            }
            cnt++;
        }

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
            if (visited[nr][nc]) continue;

            int idx = grid[nr][nc] - 'A';
            if (nxt[cur][idx] == 0) continue;

            word.append(grid[nr][nc]);
            find(nr, nc, nxt[cur][idx], word);
            word.deleteCharAt(word.length() - 1);
        }

        visited[r][c] = false;
    }

    static void solve(int r, int c) {
        int idx = grid[r][c] - 'A';
        if (nxt[ROOT][idx] == 0) return;

        StringBuilder word = new StringBuilder();
        word.append(grid[r][c]);
        find(r, c, nxt[ROOT][idx], word);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(br.readLine());
        while (w-- > 0) {
            insert(br.readLine());
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        while (b-- > 0) {
            for (int i = 0; i < 4; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            if (b != 0) br.readLine();

            point = 0;
            longest = "";
            cnt = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    solve(i, j);
                }
            }

            sb.append(point).append(" ").append(longest).append(" ").append(cnt).append("\n");
            mark++;
        }

        System.out.println(sb);
    }
}
