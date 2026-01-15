package day_15.boj_2822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[8][2];
        for (int i = 0; i < 8; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int sum = 0;
        boolean[] visited = new boolean[8];
        for (int i = 3; i < 8; i++) {
            sum += arr[i][1];
            visited[arr[i][0]] = true;
        }

        System.out.println(sum);
        for (int i = 0; i < 8; i++) {
            if (visited[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}
