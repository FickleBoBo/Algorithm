package day_14.boj_1201;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if ((n + k - 1) / k > m || n - k + 1 < m) {
            System.out.println(-1);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < n; i += k) {
            reverse(arr, i, Math.min(i + k - 1, n - 1));
        }

        int cnt = m - (n + k - 1) / k;
        int right = n - 1;
        while (cnt > 0) {
            int max = 0;
            int idx = 0;
            for (int i = 0; i <= right; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    idx = i;
                }
            }

            for (int i = idx; i < right; i++) {
                arr[i] = arr[i + 1];
            }
            arr[right] = max;

            if (idx != right) cnt--;
            right--;
        }

        for (int x : arr) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
