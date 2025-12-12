package day_12.boj_2851;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] pSum = new int[1 + 10];
        for (int i = 1; i <= 10; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];
        }

        int ans = 0;
        int diff = 1_000;
        for (int i = 1; i <= 10; i++) {
            if (Math.abs(pSum[i] - 100) <= diff) {
                ans = pSum[i];
                diff = Math.abs(pSum[i] - 100);
            }
        }

        System.out.println(ans);
    }
}
