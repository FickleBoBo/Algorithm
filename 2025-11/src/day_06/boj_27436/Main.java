package day_06.boj_27436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        System.out.println(lowerBound(N));
    }

    private static long lowerBound(long key) {
        long left = 1;
        long right = 2_000_000_000;

        while (left < right) {
            long mid = (left + right) / 2;

            // n개의 방을 지나면 최대 3 * n * (n - 1) + 1번 방까지 갈 수 있음
            if ((3 * mid * (mid - 1) + 1) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
