package day_08.boj_10103;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sumA = 100;
        int sumB = 100;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                sumB -= a;
            } else if (a < b) {
                sumA -= b;
            }
        }

        System.out.println(sumA);
        System.out.println(sumB);
    }
}
