package day_18.boj_4134;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());

            if (N <= 1) {
                sb.append("2\n");
                continue;
            }

            out:
            while (true) {
                for (long i = 2; i * i <= N; i++) {
                    if (N % i == 0) {
                        N++;
                        continue out;
                    }
                }

                sb.append(N).append("\n");
                break;
            }
        }

        System.out.print(sb);
    }
}
