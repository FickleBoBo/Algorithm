package day_27.boj_5446;

import java.io.*;

public class Main {

    static final int MX = 1 + 1000 * 20;
    static final int ROOT = 0;
    static int unused;
    static int[][] nxt;
    static boolean[] chk;
    static int[] cnt;  // 해당 노드의 자손 노드(해당 노드 포함) 중 지워야 하는 파일의 수
    static boolean[] mark;  // 지우면 안되는 파일의 접두어에 해당하는 노드들 체크

    static void init() {
        unused = ROOT + 1;
        nxt = new int[MX][128];
        chk = new boolean[MX];
        cnt = new int[MX];
        mark = new boolean[MX];
    }

    static void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c] == 0) nxt[cur][c] = unused++;
            cur = nxt[cur][c];
            cnt[cur]++;
        }
        chk[cur] = true;
    }

    static void check(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c] == 0) return;
            cur = nxt[cur][c];
            mark[cur] = true;
        }
    }

    static int solve(int cur) {
        int sum = chk[cur] ? 1 : 0;
        for (int i = 0; i < 128; i++) {
            if (nxt[cur][i] == 0) continue;

            if (mark[nxt[cur][i]]) {
                sum += solve(nxt[cur][i]);
            } else {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            init();

            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                insert(br.readLine());
            }

            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("1\n");  // rm * 사용
                continue;
            }
            while (n-- > 0) {
                check(br.readLine());
            }

            sb.append(solve(ROOT)).append("\n");
        }

        System.out.println(sb);
    }
}
