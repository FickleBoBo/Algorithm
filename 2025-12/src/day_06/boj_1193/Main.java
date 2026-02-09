package day_06.boj_1193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int numerator = 1;  // 분자
        int denominator = 1;  // 분모
        int order = 1;
        while (order < x) {
            while (order < x && numerator > 1) {
                numerator--;
                denominator++;
                order++;
            }
            if (order == x) break;
            denominator++;
            order++;

            while (order < x && denominator > 1) {
                numerator++;
                denominator--;
                order++;
            }
            if (order == x) break;
            numerator++;
            order++;
        }

        System.out.printf("%d/%d", numerator, denominator);
    }
}
