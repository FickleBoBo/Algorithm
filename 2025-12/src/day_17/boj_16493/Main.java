package day_17.boj_16493;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] days;
    static int[] pages;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        days = new int[m];
        pages = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }

    static void dfs(int idx, int daySum, int pageSum) {
        if (daySum > n) return;  // 읽는데 소요된 일수의 합이 N보다 크면 불가능한 경우

        if (idx == m) {
            max = Math.max(max, pageSum);
            return;
        }

        dfs(idx + 1, daySum + days[idx], pageSum + pages[idx]);  // 현재 챕터를 읽는 경우
        dfs(idx + 1, daySum, pageSum);  // 현재 챕터를 안 읽는 경우
    }
}
