package day_25.boj_20922;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;  // 최대 길이
        int[] cntArr = new int[1 + 100_000];  // 카운팅 배열

        while (right < N) {
            if (cntArr[arr[right]] < K) {
                cntArr[arr[right]]++;
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                cntArr[arr[left]]--;
                left++;
            }
        }

        System.out.println(maxLen);
    }
}
