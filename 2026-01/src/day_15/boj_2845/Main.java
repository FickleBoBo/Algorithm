package day_15.boj_2845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : arr) {
            sb.append(x - l * p).append(" ");
        }

        System.out.println(sb);
    }
}
