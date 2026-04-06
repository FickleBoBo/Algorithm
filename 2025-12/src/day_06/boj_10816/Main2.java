package day_06.boj_10816;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MAX = 10_000_000;
    static int[] cnt = new int[MAX + 1 + MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            cnt[x + MAX]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(cnt[x + MAX]).append(" ");
        }

        System.out.println(sb);
    }
}
