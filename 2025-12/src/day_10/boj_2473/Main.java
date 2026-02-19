package day_10.boj_2473;

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

        long sum = 3_000_000_000L;
        int[] ans = {0, 0, 0};

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int idx1 = lowerBound(arr, j + 1, -(arr[i] + arr[j]));
                int idx2 = upperBound(arr, j + 1, -(arr[i] + arr[j])) - 1;

                if (idx1 != n && Math.abs((long) arr[i] + arr[j] + arr[idx1]) < sum) {
                    sum = Math.abs((long) arr[i] + arr[j] + arr[idx1]);
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    ans[2] = arr[idx1];
                }

                if (idx2 != j && idx2 != n && Math.abs((long) arr[i] + arr[j] + arr[idx2]) < sum) {
                    sum = Math.abs((long) arr[i] + arr[j] + arr[idx2]);
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    ans[2] = arr[idx2];
                }
            }
        }

        System.out.printf("%d %d %d", ans[0], ans[1], ans[2]);
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
