package day_31.boj_2742;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >= 1; i--) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
