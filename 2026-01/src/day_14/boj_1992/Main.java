package day_14.boj_1992;

import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        recur(map, 0, 0, N, N);

        System.out.println(sb);
    }

    static void recur(char[][] map, int r1, int c1, int r2, int c2) {
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
            sb.append(map[r1][c1]);
        } else {
            sb.append("(");

            int mr = (r1 + r2) / 2;
            int mc = (c1 + c2) / 2;

            recur(map, r1, c1, mr, mc);
            recur(map, r1, mc, mr, c2);
            recur(map, mr, c1, r2, mc);
            recur(map, mr, mc, r2, c2);

            sb.append(")");
        }
    }
}
