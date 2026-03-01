package day_27.boj_14426;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MX = 1 + 10000 * 500;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][26];

    static void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
            cur = nxt[cur][idx];
        }
    }

    static boolean find(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (nxt[cur][idx] == 0) return false;
            cur = nxt[cur][idx];
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            insert(br.readLine());
        }

        int cnt = 0;
        while (m-- > 0) {
            if (find(br.readLine())) cnt++;
        }

        System.out.println(cnt);
    }
}
