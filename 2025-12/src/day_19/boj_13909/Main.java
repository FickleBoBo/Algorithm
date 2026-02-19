package day_19.boj_13909;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        while (cnt * cnt <= n) {
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
