package day_12.boj_16493;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] days;
    private static int[] pages;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        days = new int[M];
        pages = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0, 0, 0);

        System.out.println(max);
    }

    private static void powerSet(int idx, int daySum, int pageSum) {
        if (daySum > N) return;  // 읽는데 소요된 일수의 합이 N보다 크면 불가능한 경우

        if (idx == M) {
            max = Math.max(max, pageSum);
            return;
        }

        powerSet(idx + 1, daySum + days[idx], pageSum + pages[idx]);  // 현재 챕터를 읽는 경우
        powerSet(idx + 1, daySum, pageSum);  // 현재 챕터를 안 읽는 경우
    }
}
