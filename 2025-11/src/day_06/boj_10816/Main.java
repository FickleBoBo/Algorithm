package day_06.boj_10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);  // 이분 탐색을 위해 정렬

        br.readLine();  // M 입력값은 버림

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, num) - lowerBound(arr, num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // arr에서 Key 이상인 값이 등장하는 최소 인덱스 리턴
    private static int lowerBound(int[] arr, int key) {
        int left = 0;
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

    // arr에서 Key 초과인 값이 등장하는 최소 인덱스 리턴
    private static int upperBound(int[] arr, int key) {
        int left = 0;
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
