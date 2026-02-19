package day_09.boj_2003;

import java.io.*;
import java.util.*;

public class Main2 {
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

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum < m) {
                sum += arr[right++];
            } else {
                if (sum == m) cnt++;
                sum -= arr[left++];
            }

            if (right == n && sum < m) break;
        }

        System.out.println(cnt);
    }
}
