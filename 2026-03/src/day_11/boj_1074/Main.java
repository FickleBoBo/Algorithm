package day_11.boj_1074;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(dfs(n, r, c));
    }

    static int dfs(int n, int r, int c) {
        if (n == 0) return 0;

        int len = 1 << (n - 1);
        int area = len * len;

        if (r < len) {
            if (c < len) {
                return dfs(n - 1, r, c);
            } else {
                return area + dfs(n - 1, r, c - len);
            }
        } else {
            if (c < len) {
                return area * 2 + dfs(n - 1, r - len, c);
            } else {
                return area * 3 + dfs(n - 1, r - len, c - len);
            }
        }
    }
}
