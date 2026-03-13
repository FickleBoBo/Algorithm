package day_05.boj_1316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        out:
        while (n-- > 0) {
            String s = br.readLine();
            boolean[] vis = new boolean[26];
            char prv = '\u0000';

            for (char c : s.toCharArray()) {
                if (vis[c - 'a'] && c != prv) continue out;

                vis[c - 'a'] = true;
                prv = c;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
