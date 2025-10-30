package day_29.boj_21921;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우의 방문자 수 합 계산
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        // 윈도우를 이동하며 최대 방문자수 계산
        int max = sum;
        int cnt = 1;
        for (int i = 0; i < N - X; i++) {
            sum = sum - arr[i] + arr[i + X];

            // 이동한 구간의 최대 방문자 수가 더 많으면 최댓값과 개수를 갱신하고 동일하면 개수만 갱신
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
