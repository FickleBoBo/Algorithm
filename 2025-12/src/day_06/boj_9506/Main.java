package day_06.boj_9506;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) break;

            List<String> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(String.valueOf(i));
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ").append(String.join(" + ", list)).append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }

        System.out.println(sb);
    }
}
