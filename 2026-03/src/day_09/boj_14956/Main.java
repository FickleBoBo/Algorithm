package day_09.boj_14956;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pos = dfs(n, m);
        System.out.println(pos[0] + " " + pos[1]);
    }

    static int[] dfs(int n, int m) {
        if (n == 1) return new int[]{1, 1};

        int len = n / 2;
        int area = len * len;

        int q = (m - 1) / area;
        int nxt = (m - 1) % area + 1;

        int[] p = dfs(n / 2, nxt);
        int x = p[0];
        int y = p[1];

        if (q == 0) return new int[]{y, x};
        if (q == 1) return new int[]{x, y + len};
        if (q == 2) return new int[]{x + len, y + len};
        return new int[]{2 * len - y + 1, len - x + 1};
    }
}
