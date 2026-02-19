package day_18.boj_4134;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            if (n <= 1) {
                sb.append("2\n");
                continue;
            }

            out:
            while (true) {
                for (long i = 2; i * i <= n; i++) {
                    if (n % i == 0) {
                        n++;
                        continue out;
                    }
                }

                sb.append(n).append("\n");
                break;
            }
        }

        System.out.print(sb);
    }
}
