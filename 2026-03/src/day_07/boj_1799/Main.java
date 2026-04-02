package day_07.boj_1799;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 10;
    static int n;
    static boolean[] d = new boolean[MAX * 2];  // 좌상에서 우하 방향 대각선
    static int cnt;

    static List<int[]>[] poslist = new ArrayList[MAX * 2];

    static {
        for (int i = 0; i < MAX * 2; i++) {
            poslist[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) poslist[i + j].add(new int[]{i, j});
            }
        }

        int ans = 0;

        cnt = 0;
        solve(0, 0);  // 하얀색 칸에 대한 비숍 배치
        ans += cnt;

        cnt = 0;
        solve(1, 0);  // 검은색 칸에 대한 비숍 배치
        ans += cnt;

        System.out.println(ans);
    }

    static void solve(int idx, int depth) {
        if (idx >= 2 * n - 1) {
            cnt = Math.max(cnt, depth);
            return;
        }

        boolean flag = false;
        for (int[] pos : poslist[idx]) {
            int r = pos[0];
            int c = pos[1];

            if (d[r - c + n - 1]) continue;

            d[r - c + n - 1] = true;
            solve(idx + 2, depth + 1);
            d[r - c + n - 1] = false;
            flag = true;
        }

        if (!flag) {
            solve(idx + 2, depth);
        }
    }
}
