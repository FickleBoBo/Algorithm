package day_01.boj_10163;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] map = new int[1001][1001];

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int rLen = Integer.parseInt(st.nextToken());
            int cLen = Integer.parseInt(st.nextToken());

            for (int r = sr; r < sr + rLen; r++) {
                for (int c = sc; c < sc + cLen; c++) {
                    map[r][c] = i;
                }
            }
        }

        int[] cntArr = new int[1 + N];
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                cntArr[map[i][j]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(cntArr[i]).append("\n");
        }

        System.out.print(sb);
    }
}
