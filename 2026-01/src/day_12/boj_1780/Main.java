package day_12.boj_1780;

import java.io.*;
import java.util.*;

public class Main {

    static int[] cntArr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(map, 0, 0, N, N);

        System.out.println(cntArr[0]);
        System.out.println(cntArr[1]);
        System.out.println(cntArr[2]);
    }

    static void recur(int[][] map, int r1, int c1, int r2, int c2) {
        boolean flag = true;
        int color = map[r1][c1];

        out:
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (map[i][j] != color) {
                    flag = false;
                    break out;
                }
            }
        }

        if (flag) {
            cntArr[color + 1]++;
        } else {
            int mr1 = r1 + (r2 - r1) / 3;
            int mc1 = c1 + (c2 - c1) / 3;
            int mr2 = r1 + (r2 - r1) / 3 * 2;
            int mc2 = c1 + (c2 - c1) / 3 * 2;

            recur(map, r1, c1, mr1, mc1);
            recur(map, r1, mc1, mr1, mc2);
            recur(map, r1, mc2, mr1, c2);
            recur(map, mr1, c1, mr2, mc1);
            recur(map, mr1, mc1, mr2, mc2);
            recur(map, mr1, mc2, mr2, c2);
            recur(map, mr2, c1, r2, mc1);
            recur(map, mr2, mc1, r2, mc2);
            recur(map, mr2, mc2, r2, c2);
        }
    }
}
