package day_06.boj_1427;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("");
        int[] cnt = new int[10];

        for (String str : input) {
            cnt[Integer.parseInt(str)]++;
        }

        for (int i = 9; i >= 0; i--) {
            sb.append(String.valueOf(i).repeat(cnt[i]));
        }

        System.out.println(sb);
    }
}
