package day_24.boj_10469;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] grid = new char[8][8];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (grid[i][j] == '*') {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (list.size() != 8) {
            System.out.println("invalid");
            return;
        }

        for (int[] pos : list) {
            if (invalid(pos, grid)) {
                System.out.println("invalid");
                return;
            }
        }

        System.out.println("valid");
    }

    static boolean invalid(int[] pos, char[][] grid) {
        for (int d = 0; d < 8; d++) {
            int nr = pos[0] + dr[d];
            int nc = pos[1] + dc[d];

            while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                if (grid[nr][nc] == '*') return true;
                nr += dr[d];
                nc += dc[d];
            }
        }

        return false;
    }
}
