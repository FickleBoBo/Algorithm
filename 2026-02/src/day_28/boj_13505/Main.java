package day_28.boj_13505;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1 + 100000 * 32;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][2];

    static void insert(int x) {
        int cur = ROOT;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (nxt[cur][b] == 0) nxt[cur][b] = unused++;
            cur = nxt[cur][b];
        }
    }

    static int find(int x) {
        int cur = ROOT;
        int res = 0;

        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (nxt[cur][1 - b] != 0) {
                res |= (1 << i);
                cur = nxt[cur][1 - b];
            } else {
                cur = nxt[cur][b];
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(max, find(x));
            insert(x);
        }

        System.out.println(max);
    }
}
