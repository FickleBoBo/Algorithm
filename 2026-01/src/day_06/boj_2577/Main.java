package day_06.boj_2577;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;
        int[] cnt = new int[10];

        while (result > 0) {
            cnt[result % 10]++;
            result /= 10;
        }

        for (int x : cnt) {
            System.out.println(x);
        }
    }
}
