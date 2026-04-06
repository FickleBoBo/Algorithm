package day_24.boj_35306;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] chk = new boolean[n];
        for (int j = 0; j < k; j++) {
            int max = 0;
            int cnt = 0;
            int idx = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    cnt = 1;
                    idx = i;
                } else if (arr[i][j] == max) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                chk[idx] = true;
            }
        }

        int cnt = 0;
        for (boolean flag : chk) {
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
