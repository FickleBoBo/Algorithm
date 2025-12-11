package day_10.boj_1253;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                // 이분 탐색으로 찾으면 좋은 수
                if (binarySearch(arr, Math.min(i, j), Math.max(i, j), arr[i] - arr[j])) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    // 배열을 pivot1, pivot2로 분할한 세 구간 중 key가 존재하는지 리턴
    static boolean binarySearch(int[] arr, int pivot1, int pivot2, int key) {
        return Arrays.binarySearch(arr, 0, pivot1, key) >= 0 ||
                Arrays.binarySearch(arr, pivot1 + 1, pivot2, key) >= 0 ||
                Arrays.binarySearch(arr, pivot2 + 1, arr.length, key) >= 0;
    }
}
