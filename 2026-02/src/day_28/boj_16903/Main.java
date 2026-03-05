package day_28.boj_16903;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1 + 200000 * 32;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][2];
    static int[] cnt = new int[MX];

    static void insert(int x) {
        int cur = ROOT;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (nxt[cur][b] == 0) nxt[cur][b] = unused++;
            cur = nxt[cur][b];
            cnt[cur]++;
        }
    }

    static int find(int x) {
        int cur = ROOT;
        int res = 0;

        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (nxt[cur][1 - b] != 0 && cnt[nxt[cur][1 - b]] > 0) {
                res |= (1 << i);
                cur = nxt[cur][1 - b];
            } else {
                cur = nxt[cur][b];
            }
        }

        return res;
    }

    static void erase(int x) {
        int cur = ROOT;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            cur = nxt[cur][b];
            cnt[cur]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        insert(0);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (q == 1) {
                insert(x);
            } else if (q == 2) {
                erase(x);
            } else {
                sb.append(find(x)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
