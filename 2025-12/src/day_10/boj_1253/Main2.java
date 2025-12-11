package day_10.boj_1253;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                // 왼쪽 포인터가 i면 넘어감
                if (left == i) {
                    left++;
                    continue;
                }

                // 오른쪽 포인터가 i면 넘어감
                if (right == i) {
                    right--;
                    continue;
                }

                if (arr[left] + arr[right] > arr[i]) {
                    right--;
                } else if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
