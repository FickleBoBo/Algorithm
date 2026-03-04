package day_22.boj_18186;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[2 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < 2 + n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (b <= c) {
            long cnt = 0;

            for (int x : arr) {
                cnt += x;
            }

            System.out.println(cnt * b);
        } else {
            long[][] cnt = new long[2 + n][3];
            for (int i = 2; i < 2 + n; i++) {
                long x = arr[i];
                long[] prev = cnt[i - 1];

                if (x >= prev[0]) {
                    cnt[i][1] = prev[0];
                    x -= prev[0];
                } else {
                    cnt[i][1] = x;
                    continue;
                }

                if (x >= prev[1]) {
                    cnt[i][2] = prev[1];
                    x -= prev[1];
                } else {
                    cnt[i][2] = x;
                    continue;
                }

                cnt[i][0] = x;
            }

            long sum = 0;
            for (long[] row : cnt) {
                sum += b * row[0] + c * (row[1] + row[2]);
            }

            System.out.println(sum);
        }
    }
}
