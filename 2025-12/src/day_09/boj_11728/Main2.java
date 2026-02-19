package day_09.boj_11728;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        int[] ans = new int[n + m];

        int pivot1 = 0;  // arr1 포인터
        int pivot2 = 0;  // arr2 포인터
        int idx = 0;  // ans 포인터
        while (pivot1 < n && pivot2 < m) {
            if (arr1[pivot1] <= arr2[pivot2]) {
                ans[idx++] = arr1[pivot1++];
            } else {
                ans[idx++] = arr2[pivot2++];
            }
        }

        // 남은 수 처리
        while (pivot1 == n && pivot2 < m) {
            ans[idx++] = arr2[pivot2++];
        }

        // 남은 수 처리
        while (pivot2 == m && pivot1 < n) {
            ans[idx++] = arr1[pivot1++];
        }

        for (int x : ans) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
