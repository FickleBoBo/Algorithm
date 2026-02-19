package day_16.boj_30804;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int[] cnt = new int[10];
        int typeCnt = 0;
        int max = 0;

        while (true) {
            if (typeCnt > 2) {
                cnt[arr[left]]--;
                if (cnt[arr[left]] == 0) typeCnt--;
                left++;
            } else {
                if (cnt[arr[right]] == 0) typeCnt++;
                cnt[arr[right]]++;
                right++;
            }

            if (typeCnt <= 2) max = Math.max(max, right - left);

            if (right == n && typeCnt <= 2) break;
        }

        System.out.println(max);
    }
}
