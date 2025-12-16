package day_07.boj_2756;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int p1 = 0;
            int p2 = 0;

            st = new StringTokenizer(br.readLine());
            p1 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            p1 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            p1 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            p2 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            p2 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            p2 += getPoint(dist(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));

            if (p1 > p2) {
                sb.append("SCORE: ").append(p1).append(" to ").append(p2).append(", PLAYER 1 WINS.\n");
            } else if (p1 < p2) {
                sb.append("SCORE: ").append(p1).append(" to ").append(p2).append(", PLAYER 2 WINS.\n");
            } else {
                sb.append("SCORE: ").append(p1).append(" to ").append(p2).append(", TIE.\n");
            }
        }

        System.out.println(sb);
    }

    static double dist(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    static int getPoint(double dist) {
        if (dist <= 3) return 100;
        if (dist <= 6) return 80;
        if (dist <= 9) return 60;
        if (dist <= 12) return 40;
        if (dist <= 15) return 20;
        return 0;
    }
}
