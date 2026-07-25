package day_25.boj_14888;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[12];
    static int[] oper = new int[4];
    static final int INF = 1_000_000_000;
    static int n;
    static int max = -INF;
    static int min = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int ans) {
        if (idx == n) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) continue;

            oper[i]--;
            if (i == 0) {
                dfs(idx + 1, ans + arr[idx]);
            } else if (i == 1) {
                dfs(idx + 1, ans - arr[idx]);
            } else if (i == 2) {
                dfs(idx + 1, ans * arr[idx]);
            } else {
                dfs(idx + 1, ans / arr[idx]);
            }
            oper[i]++;
        }
    }
}
