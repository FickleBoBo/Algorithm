package day_07.boj_1064;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xa = Integer.parseInt(st.nextToken());
        int ya = Integer.parseInt(st.nextToken());
        int xb = Integer.parseInt(st.nextToken());
        int yb = Integer.parseInt(st.nextToken());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());

        if (ccw(xa, ya, xb, yb, xc, yc) == 0) {
            System.out.println(-1);
        } else {
            double[] sides = {dist(xa, ya, xb, yb), dist(xb, yb, xc, yc), dist(xc, yc, xa, ya)};
            Arrays.sort(sides);

            System.out.println(2 * (sides[2] - sides[0]));
        }
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Integer.signum((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
    }

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
