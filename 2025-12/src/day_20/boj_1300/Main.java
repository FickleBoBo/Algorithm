package day_20.boj_1300;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(lowerBound(n, k));
    }

    static int lowerBound(int n, int k) {
        int left = 1;
        int right = (int) Math.min(1_000_000_000, (long) n * n);

        while (left < right) {
            int mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
