package day_09.boj_2003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] psum = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + arr[i - 1];
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (psum[j] - psum[i - 1] == m) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
