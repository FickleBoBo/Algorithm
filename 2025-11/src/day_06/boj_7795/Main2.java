package day_06.boj_7795;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            int pivotA = 0;  // A의 포인터
            int pivotB = 0;  // B의 포인터
            int cnt = 0;

            while (true) {
                if (pivotB < M && A[pivotA] > B[pivotB]) {
                    pivotB++;
                } else {
                    cnt += pivotB;
                    pivotA++;
                }

                if (pivotA == N) break;
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
