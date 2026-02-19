package day_10.boj_7795;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            int pivotA = 0;  // A의 포인터
            int pivotB = 0;  // B의 포인터
            int cnt = 0;

            while (pivotA < n) {
                if (pivotB < m && a[pivotA] > b[pivotB]) {
                    pivotB++;
                } else {
                    cnt += pivotB;
                    pivotA++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
