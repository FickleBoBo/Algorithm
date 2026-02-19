package day_12.boj_13305;

import java.io.*;
import java.util.*;

public class Main {

    static int MAX_PRICE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dist = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = MAX_PRICE;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            sum += minPrice * dist[i];
        }

        System.out.println(sum);
    }
}
