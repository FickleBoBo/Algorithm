package day_27.boj_10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int[] cntArr = new int[26];

        for (char c : S.toCharArray()) {
            cntArr[c - 'a']++;
        }

        for (int cnt : cntArr) {
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
