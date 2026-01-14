package day_14.boj_10804;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            while (start < end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;

                start++;
                end--;
            }
        }

        for (int n : arr) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
