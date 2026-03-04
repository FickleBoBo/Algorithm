package day_24.boj_28123;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {0, 1, 2, 2, 2, 3, 3, 3, 3, 3};

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        System.out.println(n - arr[x] - 3 * (k - 1) + 1);
    }
}
