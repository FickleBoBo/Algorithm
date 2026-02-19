package day_12.boj_2096;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        int[] tmp = new int[3];  // 계산값 임시저장용 배열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            // 최대 점수 계산
            tmp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
            tmp[1] = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + x2;
            tmp[2] = Math.max(maxDp[1], maxDp[2]) + x3;

            maxDp[0] = tmp[0];
            maxDp[1] = tmp[1];
            maxDp[2] = tmp[2];

            // 최소 점수 계산
            tmp[0] = Math.min(minDp[0], minDp[1]) + x1;
            tmp[1] = Math.min(minDp[0], Math.min(minDp[1], minDp[2])) + x2;
            tmp[2] = Math.min(minDp[1], minDp[2]) + x3;

            minDp[0] = tmp[0];
            minDp[1] = tmp[1];
            minDp[2] = tmp[2];
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(max + " " + min);
    }
}
