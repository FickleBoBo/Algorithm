package day_20.boj_1064;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xa = Integer.parseInt(st.nextToken());
        int ya = Integer.parseInt(st.nextToken());
        int xb = Integer.parseInt(st.nextToken());
        int yb = Integer.parseInt(st.nextToken());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());

        if ((yb - ya) * (xc - xa) == (yc - ya) * (xb - xa)) {
            System.out.println(-1);
        } else {
            double[] sides = {distance(xa, ya, xb, yb), distance(xb, yb, xc, yc), distance(xc, yc, xa, ya)};
            Arrays.sort(sides);

            System.out.println(2 * (sides[2] - sides[0]));
        }
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
