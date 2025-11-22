package day_22.boj_2230;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);  // 정렬

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (left < N && right < N) {
            if (arr[right] - arr[left] < M) {
                right++;
            } else {
                min = Math.min(min, arr[right] - arr[left]);

                left++;
            }
        }

        System.out.println(min);
    }
}
