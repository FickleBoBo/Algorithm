package day_08.boj_14908;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i][0] = i + 1;
            arr[i][1] = t;
            arr[i][2] = s;
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1] * o2[2], o2[1] * o1[2]));

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ");
        }

        System.out.println(sb);
    }
}
