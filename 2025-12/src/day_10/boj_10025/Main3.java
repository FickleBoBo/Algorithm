package day_10.boj_10025;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] input = new int[n][2];  // 양동이의 얼음의 양과 좌표를 임시 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        // 양동이의 좌표를 기준으로 정렬
        Arrays.sort(input, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (right < n) {
            // 더 잡을 수 있으면 오른쪽 포인터를 이동하며 더 잡을 수 없으면 왼쪽 포인터를 이동
            if (input[right][1] - input[left][1] > (2 * k + 1)) {
                sum -= input[left++][0];
            } else {
                sum += input[right++][0];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}
