package day_11.boj_17128;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연속한 네 마리 소들의 품질 점수의 곱 배열
        int[] arr2 = new int[N];
        arr2[0] = arr[0] * arr[1] * arr[2] * arr[3];
        for (int i = 1; i < N; i++) {
            arr2[i] = arr2[i - 1] * arr[(i + 3) % N] / arr[i - 1];
        }

        int sum = 0;
        for (int n : arr2) {
            sum += n;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken());

            int idx1 = (q - 4 + N) % N;
            int idx2 = (q - 3 + N) % N;
            int idx3 = (q - 2 + N) % N;
            int idx4 = q - 1;

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

        bw.write(sb.toString());
        bw.flush();
    }
}
