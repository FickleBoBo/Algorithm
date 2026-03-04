package day_23.boj_35296;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') continue;

                if (i < n - 1 && grid[i + 1][j] == 'X') {
                    sb.append("2 ").append(i + 1 + n * j).append(" ").append(i + 2 + n * j).append("\n");
                    grid[i][j] = 'O';
                    grid[i + 1][j] = 'O';
                } else if (n == 1 && j < m - 1 && grid[i][j + 1] == 'X') {
                    sb.append("2 ").append(i + 1 + n * j).append(" ").append(i + 1 + n * (j + 1)).append("\n");
                    grid[i][j] = 'O';
                    grid[i][j + 1] = 'O';
                } else {
                    sb.append("1 ").append(i + 1 + n * j).append("\n");
                    grid[i][j] = 'O';
                }
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
