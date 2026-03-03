package day_19.boj_1213;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            cnt[c - 'A']++;
        }

        boolean flag = true;
        if (str.length() % 2 == 0) {
            for (int x : cnt) {
                if (x % 2 == 1) {
                    flag = false;
                    break;
                }
            }
        } else {
            int oddCnt = 0;
            for (int x : cnt) {
                if (x % 2 == 1) {
                    oddCnt++;
                }
            }

            if (oddCnt != 1) {
                flag = false;
            }
        }

        if (flag) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    sb.append(String.valueOf((char) (i + 'A')).repeat(cnt[i] / 2));
                }
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] % 2 == 1) {
                    sb.append((char) (i + 'A'));
                    break;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    sb.append(String.valueOf((char) (i + 'A')).repeat(cnt[i] / 2));
                }
            }
            System.out.println(sb);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}
