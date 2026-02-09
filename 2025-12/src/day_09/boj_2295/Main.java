package day_09.boj_2295;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);  // 역순 조회로 d를 발견하면 종료하기 위해 정렬

        int[] sum = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum);  // 이분 탐색을 위해 정렬

        // a + b + c = d -> a + b = d - c
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Arrays.binarySearch(sum, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
