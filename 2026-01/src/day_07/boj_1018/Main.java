package day_07.boj_1018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = 32;
        for (int r = 0; r <= n - 8; r++) {
            for (int c = 0; c <= m - 8; c++) {
                int isWhite = 0;  // 맨 왼쪽 위 칸을 흰색으로 둘 경우
                int isBlack = 0;  // 맨 왼쪽 위 칸을 검은색으로 둘 경우

                for (int i = r; i < r + 8; i++) {
                    for (int j = c; j < c + 8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (board[i][j] == 'B') {
                                isWhite++;
                            } else {
                                isBlack++;
                            }
                        } else {
                            if (board[i][j] == 'W') {
                                isWhite++;
                            } else {
                                isBlack++;
                            }
                        }
                    }
                }

                min = Math.min(min, Math.min(isWhite, isBlack));
            }
        }

        System.out.println(min);
    }
}
