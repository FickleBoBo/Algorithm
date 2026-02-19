package day_10.boj_2470;

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

        int left = 0;
        int right = n - 1;
        int sum = Integer.MAX_VALUE;
        int[] ans = {0, 0};

        while (left < right) {
            if (arr[left] + arr[right] > 0) {
                if (Math.abs(arr[left] + arr[right]) < sum) {
                    sum = Math.abs(arr[left] + arr[right]);
                    ans[0] = arr[left];
                    ans[1] = arr[right];
                }
                right--;
            } else if (arr[left] + arr[right] < 0) {
                if (Math.abs(arr[left] + arr[right]) < sum) {
                    sum = Math.abs(arr[left] + arr[right]);
                    ans[0] = arr[left];
                    ans[1] = arr[right];
                }
                left++;
            } else {
                ans[0] = arr[left];
                ans[1] = arr[right];
                break;
            }
        }

        System.out.printf("%d %d", ans[0], ans[1]);
    }
}
