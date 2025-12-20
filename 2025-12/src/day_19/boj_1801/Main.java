package day_19.boj_1801;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += arr[i] = Integer.parseInt(st.nextToken());
        }
        int half = sum / 2;  // 전체 막대 길이의 절반

        boolean[][][][] dp = new boolean[half][half][half][half];  // 각 변은 전체 막대 길이의 절반 미만이어야 함
        dp[0][0][0][0] = true;

        for (int n : arr) {
            List<int[]> list = new ArrayList<>();

            // b, d는 항상 a, c보다 길게 저장하여 탐색 범위 축소
            for (int a = 0; a < half; a++) {
                for (int b = a; b < half; b++) {
                    for (int c = 0; c < half; c++) {
                        for (int d = c; d < half; d++) {
                            if (!dp[a][b][c][d]) continue;  // 현재 불가능한 케이스면 넘김

                            // a에 막대를 붙이려고 할 경우 a + n이 b보다 작으면 붙이고 크면 붙이되 순서를 뒤바꿔서 항상 b가 더 크게 저장
                            if (Math.max(a + n, b) < half)
                                list.add(new int[]{Math.min(a + n, b), Math.max(a + n, b), c, d});

                            // b에 막대를 붙이려고 할 경우 half 보다 작으면서 인접한 변과의 합도 half 이하여야 함
                            if (b + n < half && b + n + d <= half) list.add(new int[]{a, b + n, c, d});

                            // c에 막대를 붙이려고 할 경우 c + n이 d보다 작으면 붙이고 크면 붙이되 순서를 뒤바꿔서 항상 d가 더 크게 저장
                            if (Math.max(c + n, d) < half)
                                list.add(new int[]{a, b, Math.min(c + n, d), Math.max(c + n, d)});

                            // d에 막대를 붙이려고 할 경우 half 보다 작으면서 인접한 변과의 합도 half 이하여야 함
                            if (d + n < half && d + n + b <= half) list.add(new int[]{a, b, c, d + n});
                        }
                    }
                }
            }

            // 가능한 후보들로 dp 갱신
            for (int[] pos : list) {
                dp[pos[0]][pos[1]][pos[2]][pos[3]] = true;
            }
        }

        int max = -1;
        for (int h = 1; h < half; h++) {
            for (int w = 1; w < half; w++) {
                if (dp[h][h][w][w]) {
                    max = Math.max(max, h * w);
                }
            }
        }

        System.out.println(max);
    }
}
