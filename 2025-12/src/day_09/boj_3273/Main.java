package day_09.boj_3273;

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
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (left < right) {
            if (arr[left] + arr[right] < x) {
                left++;
            } else if (arr[left] + arr[right] > x) {
                right--;
            } else {
                cnt++;
                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}
