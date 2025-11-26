package day_26.boj_11054;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];  // 앞에서 뒤로 LIS
        int[] dp2 = new int[N];  // 뒤에서 앞으로 LIS
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        System.out.println(max);
    }
}
