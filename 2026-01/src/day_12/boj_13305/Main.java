package day_12.boj_13305;

import java.io.*;
import java.util.*;

public class Main {

    static int MAX_PRICE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = MAX_PRICE;
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            sum += minPrice * dist[i];
        }

        System.out.println(sum);
    }
}
