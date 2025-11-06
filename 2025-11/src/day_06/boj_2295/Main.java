package day_06.boj_2295;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);  // 역순 조회로 d를 발견하면 종료하기 위해 정렬

        int[] sumArr = new int[N * (N + 1) / 2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumArr[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sumArr);  // 이분 탐색을 위해 정렬

        // a + b + c = d -> a + b = d - c
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Arrays.binarySearch(sumArr, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
