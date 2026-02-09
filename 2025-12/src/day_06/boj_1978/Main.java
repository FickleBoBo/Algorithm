package day_06.boj_1978;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        out:
        for (int x : arr) {
            if (x == 1) continue;

            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) continue out;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
