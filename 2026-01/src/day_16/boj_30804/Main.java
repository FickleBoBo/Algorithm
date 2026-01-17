package day_16.boj_30804;

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

        int left = 0;
        int right = 0;
        int[] cntArr = new int[10];
        int typeCnt = 0;
        int max = 0;

        while (true) {
            if (typeCnt > 2) {
                cntArr[arr[left]]--;
                if (cntArr[arr[left]] == 0) typeCnt--;
                left++;
            } else {
                if (cntArr[arr[right]] == 0) typeCnt++;
                cntArr[arr[right]]++;
                right++;
            }

            if (typeCnt <= 2) max = Math.max(max, right - left);

            if (right == N && typeCnt <= 2) break;
        }

        System.out.println(max);
    }
}
