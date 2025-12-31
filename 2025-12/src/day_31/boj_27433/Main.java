package day_31.boj_27433;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long fact = 1;
        for (int i = 1; i <= N; i++) {
            fact *= i;
        }

        System.out.println(fact);
    }
}
