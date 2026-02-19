package day_09.boj_27436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(lowerBound(n));
    }

    static long lowerBound(long key) {
        long left = 1;
        long right = 2_000_000_000;

        while (left < right) {
            long mid = (left + right) / 2;

            if ((3 * mid * (mid - 1) + 1) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
