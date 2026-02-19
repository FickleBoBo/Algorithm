package day_27.boj_10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] cnt = new int[26];

        for (char c : str.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int x : cnt) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
