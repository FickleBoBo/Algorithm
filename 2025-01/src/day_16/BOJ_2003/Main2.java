package day_16.BOJ_2003;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum < M) {
                sum += arr[right++];
            } else if (sum > M) {
                sum -= arr[left++];
            } else {
                cnt++;
                sum -= arr[left++];
            }

            if (right == N && sum < M) break;
        }

        System.out.println(cnt);
    }
}
