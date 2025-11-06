package day_06.boj_12779;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long cnt = getSquareNum(a, b);

        if (cnt == 0) {
            System.out.println(0);
        } else {
            long gcd = gcd(cnt, b - a);
            System.out.printf("%d/%d", cnt / gcd, (b - a) / gcd);
        }
    }

    public static long getSquareNum(long a, long b) {
        int cnt = 0;

        for (long i = (long) Math.sqrt(a); i * i <= b; i++) {
            if (i * i > a) cnt++;
        }

        return cnt;
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
