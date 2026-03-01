package day_27.boj_5052;

import java.io.*;

public class Main {

    static final int MX = 1 + 10000 * 10;
    static final int ROOT = 0;
    static int unused;
    static int[][] nxt;
    static boolean[] chk;

    static void init() {
        unused = ROOT + 1;
        nxt = new int[MX][10];
        chk = new boolean[MX];
    }

    static boolean insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
            cur = nxt[cur][idx];
            if (chk[cur]) return false;
        }

        if (cur != unused - 1) return false;

        chk[cur] = true;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            init();

            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            while (n-- > 0) {
                String s = br.readLine();
                if (!flag) continue;

                if (!insert(s)) flag = false;
            }

            if (flag) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }
}
