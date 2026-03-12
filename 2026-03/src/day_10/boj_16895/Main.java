package day_10.boj_16895;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int nimsum = 0;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nimsum ^= arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int p : arr) {
            if ((p ^ nimsum) < p) cnt++;
        }

        System.out.println(cnt);
    }
}
