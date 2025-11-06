package day_06.boj_2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int n = 1;

        // n개의 방을 지나면 최대 3 * n * (n - 1) + 1번 방까지 갈 수 있음
        while ((3 * n * (n - 1) + 1) < N) {
            n++;
        }

        System.out.println(n);
    }
}
