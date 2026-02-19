package day_10.boj_2470;

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
        Arrays.sort(arr);

        int sum = Integer.MAX_VALUE;
        int[] ans = {0, 0};

        for (int i = 0; i < n - 1; i++) {
            int idx1 = lowerBound(arr, i + 1, -arr[i]);
            int idx2 = upperBound(arr, i + 1, -arr[i]) - 1;

            if (idx1 != n && Math.abs(arr[i] + arr[idx1]) < sum) {
                sum = Math.abs(arr[i] + arr[idx1]);
                ans[0] = arr[i];
                ans[1] = arr[idx1];
            }

            if (idx2 != i && idx2 != n && Math.abs(arr[i] + arr[idx2]) < sum) {
                sum = Math.abs(arr[i] + arr[idx2]);
                ans[0] = arr[i];
                ans[1] = arr[idx2];
            }
        }

        System.out.printf("%d %d", ans[0], ans[1]);
    }

    static int lowerBound(int[] arr, int left, int key) {
        int right = arr.length;

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

    static int upperBound(int[] arr, int left, int key) {
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
