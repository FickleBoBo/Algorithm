package day_19.boj_2022;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        System.out.println(lowerBound(x, y, c));
    }

    static double lowerBound(double x, double y, double c) {
        double left = 0;
        double right = Math.min(x, y);

        while (right - left > 1E-3) {
            double mid = (left + right) / 2;

            double h1 = Math.sqrt(x * x - mid * mid);
            double h2 = Math.sqrt(y * y - mid * mid);

            if (c < h1 * h2 / (h1 + h2)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
