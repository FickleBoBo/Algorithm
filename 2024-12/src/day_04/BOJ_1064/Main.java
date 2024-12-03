package day_04.BOJ_1064;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        if (ccw(x1, y1, x2, y2, x3, y3) == 0) {
            System.out.println(-1);
        } else {
            List<Double> dist = new ArrayList<>();

            dist.add(distance(x1, y1, x2, y2));
            dist.add(distance(x2, y2, x3, y3));
            dist.add(distance(x3, y3, x1, y1));

            dist.sort(Comparator.naturalOrder());

            System.out.println((dist.get(2) - dist.get(0)) * 2);
        }
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3);
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
