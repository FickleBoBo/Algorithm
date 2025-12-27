package day_05.boj_3052;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            visited[num % 42] = true;
        }

        int cnt = 0;
        for (boolean flag : visited) {
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
