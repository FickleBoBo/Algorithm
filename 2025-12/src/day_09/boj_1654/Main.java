package day_09.boj_1654;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(upperBound(arr, N) - 1);
    }

    static long upperBound(int[] arr, int key) {
        long left = 1;
        long right = Integer.MAX_VALUE + 1L;  // 랜선의 길이가 최대 2^31-1까지라서 right의 상한을 2^31로 설정

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int n : arr) {
                cnt += n / mid;
            }

            if (cnt >= key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
