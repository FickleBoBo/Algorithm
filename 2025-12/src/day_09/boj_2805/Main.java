package day_09.boj_2805;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(upperBound(arr, M) - 1);
    }

    static int upperBound(int[] arr, int M) {
        int left = 0;
        int right = 1_000_000_001;  // 나무의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

        while (left < right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int n : arr) {
                sum += Math.max(n - mid, 0);
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
