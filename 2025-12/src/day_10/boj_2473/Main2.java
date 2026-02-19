package day_10.boj_2473;

import java.io.*;
import java.util.*;

public class Main2 {
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

        out:
        for (int i = 0; i < n - 2; i++) {
            long num = arr[i];

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                if (num + arr[left] + arr[right] > 0) {
                    if (Math.abs(num + arr[left] + arr[right]) < sum) {
                        sum = Math.abs(num + arr[left] + arr[right]);
                        ans[0] = arr[i];
                        ans[1] = arr[left];
                        ans[2] = arr[right];
                    }
                    right--;
                } else if (num + arr[left] + arr[right] < 0) {
                    if (Math.abs(num + arr[left] + arr[right]) < sum) {
                        sum = Math.abs(num + arr[left] + arr[right]);
                        ans[0] = arr[i];
                        ans[1] = arr[left];
                        ans[2] = arr[right];
                    }
                    left++;
                } else {
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                    break out;
                }
            }
        }

        System.out.printf("%d %d %d", ans[0], ans[1], ans[2]);
    }
}
