package day_04.boj_2563;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] vis = new boolean[100][100];

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            for (int r = row; r < row + 10; r++) {
                for (int c = col; c < col + 10; c++) {
                    vis[r][c] = true;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (vis[i][j]) sum++;
            }
        }

        System.out.println(sum);
    }
}
