package day_11.boj_1059;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());

        int[] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        int min = 0;
        int max = 1001;
        for (int x : arr) {
            if (x <= n) min = Math.max(min, x);
            if (x >= n) max = Math.min(max, x);
        }

        System.out.println(Math.max((n - min) * (max - n) - 1, 0));
    }
}
