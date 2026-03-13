package day_05.boj_3052;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] vis = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine());
            vis[x % 42] = true;
        }

        int cnt = 0;
        for (boolean flag : vis) {
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
