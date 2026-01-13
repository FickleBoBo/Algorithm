package day_13.boj_2740;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = multiply(A, B, N, M, K);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[][] multiply(int[][] A, int[][] B, int N, int M, int K) {
        int[][] res = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }
}
