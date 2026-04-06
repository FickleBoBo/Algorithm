package day_19.boj_2170;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int ans = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (end >= arr[i][0]) {
                end = Math.max(end, arr[i][1]);
            } else {
                ans += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        ans += end - start;

        System.out.println(ans);
    }
}
