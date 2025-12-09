package day_09.boj_11728;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        int[] ans = new int[N + M];

        int pivot1 = 0;  // arr1 포인터
        int pivot2 = 0;  // arr2 포인터
        int idx = 0;  // ans 포인터
        while (pivot1 < N && pivot2 < M && idx < N + M) {
            if (arr1[pivot1] <= arr2[pivot2]) {
                ans[idx++] = arr1[pivot1++];
            } else {
                ans[idx++] = arr2[pivot2++];
            }
        }

        // 남은 수 처리
        while (pivot1 == N && idx < N + M) {
            ans[idx++] = arr2[pivot2++];
        }

        // 남은 수 처리
        while (pivot2 == M && idx < N + M) {
            ans[idx++] = arr1[pivot1++];
        }

        for (int num : ans) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
