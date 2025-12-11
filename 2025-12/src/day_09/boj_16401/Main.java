package day_09.boj_16401;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(upperBound(arr, M) - 1);
    }

    static int upperBound(int[] arr, int key) {
        int left = 1;
        int right = 1_000_000_001;  // 과자의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

        while (left < right) {
            int mid = (left + right) / 2;

            int cnt = 0;
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
