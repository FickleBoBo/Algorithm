package day_15.boj_1485;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long[][] pos = new long[4][2];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                pos[i][0] = Long.parseLong(st.nextToken());
                pos[i][1] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(pos, (o1, o2) -> {
                if (o1[0] != o2[0]) return Long.compare(o1[0], o2[0]);
                return Long.compare(o1[1], o2[1]);
            });

            long side1 = (pos[0][0] - pos[1][0]) * (pos[0][0] - pos[1][0]) + (pos[0][1] - pos[1][1]) * (pos[0][1] - pos[1][1]);
            long side2 = (pos[0][0] - pos[2][0]) * (pos[0][0] - pos[2][0]) + (pos[0][1] - pos[2][1]) * (pos[0][1] - pos[2][1]);
            long side3 = (pos[3][0] - pos[1][0]) * (pos[3][0] - pos[1][0]) + (pos[3][1] - pos[1][1]) * (pos[3][1] - pos[1][1]);
            long side4 = (pos[3][0] - pos[2][0]) * (pos[3][0] - pos[2][0]) + (pos[3][1] - pos[2][1]) * (pos[3][1] - pos[2][1]);
            long diagonal1 = (pos[3][0] - pos[0][0]) * (pos[3][0] - pos[0][0]) + (pos[3][1] - pos[0][1]) * (pos[3][1] - pos[0][1]);
            long diagonal2 = (pos[2][0] - pos[1][0]) * (pos[2][0] - pos[1][0]) + (pos[2][1] - pos[1][1]) * (pos[2][1] - pos[1][1]);

            if (side1 == side2 && side1 == side3 && side1 == side4 && diagonal1 == diagonal2) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}
