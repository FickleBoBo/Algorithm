package day_31.boj_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int ans = sum(st.nextToken());

        while (st.hasMoreTokens()) {
            ans -= sum(st.nextToken());
        }

        System.out.println(ans);
    }

    // 숫자와 +로만 이루어진 식의 합 리턴
    private static int sum(String token) {
        StringTokenizer st = new StringTokenizer(token, "+");

        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
