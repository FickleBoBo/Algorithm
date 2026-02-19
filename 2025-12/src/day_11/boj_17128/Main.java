package day_11.boj_17128;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연속한 네 마리 소들의 품질 점수의 곱 배열
        int[] arr2 = new int[n];
        arr2[0] = arr[0] * arr[1] * arr[2] * arr[3];
        for (int i = 1; i < n; i++) {
            arr2[i] = arr2[i - 1] * arr[(i + 3) % n] / arr[i - 1];
        }

        int sum = 0;
        for (int x : arr2) {
            sum += x;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(st.nextToken());

            int idx1 = (x - 4 + n) % n;
            int idx2 = (x - 3 + n) % n;
            int idx3 = (x - 2 + n) % n;
            int idx4 = x - 1;

            arr2[idx1] *= -1;
            arr2[idx2] *= -1;
            arr2[idx3] *= -1;
            arr2[idx4] *= -1;

            sum += 2 * arr2[idx1];
            sum += 2 * arr2[idx2];
            sum += 2 * arr2[idx3];
            sum += 2 * arr2[idx4];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
