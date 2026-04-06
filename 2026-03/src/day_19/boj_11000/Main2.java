package day_19.boj_11000;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n * 2][2];
        for (int i = 0; i < n * 2; i += 2) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = 1;
            arr[i + 1][0] = Integer.parseInt(st.nextToken());
            arr[i + 1][1] = -1;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n * 2; i++) {
            cnt += arr[i][1];
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
