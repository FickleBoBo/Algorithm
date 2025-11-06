package day_06.boj_2417;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(lowerBound(n));
    }

    private static long lowerBound(long key) {
        long left = 0;
        long right = (long) Math.ceil(Math.sqrt(Long.MAX_VALUE));

        while (left < right) {
            long mid = (left + right) / 2;

            if (mid * mid < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
