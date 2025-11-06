package day_06.boj_1920;

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
            // 이분 탐색 값이 0 이상이면 배열에 값이 존재하는 상황
            if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
