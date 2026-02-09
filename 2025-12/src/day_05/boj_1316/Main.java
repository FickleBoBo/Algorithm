package day_05.boj_1316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        out:
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean[] visited = new boolean[26];
            char prev = '\u0000';

            for (char c : str.toCharArray()) {
                if (visited[c - 'a'] && c != prev) continue out;

                visited[c - 'a'] = true;
                prev = c;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
