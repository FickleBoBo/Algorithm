package day_09.boj_20366;

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
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;  // 두 눈사람의 키 차이

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int left = i + 1;
                int right = j - 1;
                int sum = arr[i] + arr[j];  // 한 쪽 눈사람의 키

                while (left < right) {
                    if (arr[left] + arr[right] < sum) {
                        diff = Math.min(diff, sum - arr[left] - arr[right]);
                        left++;
                    } else {
                        if (arr[left] + arr[right] == sum) {
                            System.out.println(0);
                            return;
                        }

                        diff = Math.min(diff, arr[left] + arr[right] - sum);
                        right--;
                    }
                }
            }
        }

        System.out.println(diff);
    }
}
