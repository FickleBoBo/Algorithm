package day_09.boj_2230;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (left < n && right < n) {
            if (arr[right] - arr[left] < m) {
                right++;
            } else {
                min = Math.min(min, arr[right] - arr[left]);
                left++;
            }
        }

        System.out.println(min);
    }
}
