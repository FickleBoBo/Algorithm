package day_22.boj_18185;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cnt = new int[2 + n][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < 2 + n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int[] prv = cnt[i - 1];

            if (x >= prv[0]) {
                cnt[i][1] = prv[0];
                x -= prv[0];
            } else {
                cnt[i][1] = x;
                continue;
            }

            if (x >= prv[1]) {
                cnt[i][2] = prv[1];
                x -= prv[1];
            } else {
                cnt[i][2] = x;
                continue;
            }

            cnt[i][0] = x;
        }

        int sum = 0;
        for (int[] row : cnt) {
            sum += 3 * row[0] + 2 * (row[1] + row[2]);
        }

        System.out.println(sum);
    }
}
