package day_25.boj_16906;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1 + 1000;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][2];
    static boolean[] chk = new boolean[MX];

    static void insert(int cur, int l, StringBuilder word) {
        if (chk[cur]) return;

        if (word.length() == l) {
            if (cur != unused - 1) return;

            chk[cur] = true;
            list.add(word.toString());
            success = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (nxt[cur][i] == 0) nxt[cur][i] = unused++;
            word.append((char) ('0' + i));
            insert(nxt[cur][i], l, word);
            word.deleteCharAt(word.length() - 1);

            if (success) return;  // 0으로 끝나는 욱제어 삽입 성공시 1로 끝나는 노드 삽입 방지
        }
    }

    static boolean success;  // 욱제어 삽입 성공 여부
    static List<String> list = new ArrayList<>();  // 욱제어를 저장한 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            StringBuilder word = new StringBuilder();
            success = false;

            insert(ROOT, x, word);
            if (success) continue;

            System.out.println(-1);
            return;
        }

        System.out.println(1);
        for (String word : list) {
            System.out.println(word);
        }
    }
}
