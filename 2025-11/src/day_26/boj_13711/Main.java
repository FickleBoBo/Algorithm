package day_26.boj_13711;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[][] B = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = i;
        }
        Arrays.sort(B, ((o1, o2) -> Integer.compare(o1[0], o2[0])));

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = B[A[i] - 1][1];
        }

        int[] dp = new int[1 + N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int idx = lowerBound(dp, len, arr[i]);

            dp[idx] = arr[i];
            if (idx == len + 1) len++;
        }

        System.out.println(len);
    }

    private static int lowerBound(int[] arr, int len, int key) {
        int left = 1;
        int right = len + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
