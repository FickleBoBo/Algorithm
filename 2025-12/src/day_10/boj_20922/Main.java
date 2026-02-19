package day_10.boj_20922;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max = 0;  // 최대 길이
        int[] cnt = new int[100001];  // 카운팅 배열

        while (right < n) {
            if (cnt[arr[right]] < k) {
                cnt[arr[right]]++;
                right++;
                max = Math.max(max, right - left);
            } else {
                cnt[arr[left]]--;
                left++;
            }
        }

        System.out.println(max);
    }
}
