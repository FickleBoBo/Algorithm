package day_05.boj_1157;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] cnt = new int[26];

        for (char c : str.toCharArray()) {
            cnt[Character.toLowerCase(c) - 'a']++;
        }

        int maxIdx = -1;
        int max = 0;
        int maxCnt = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                maxIdx = i;
                max = cnt[i];
                maxCnt = 1;
            } else if (cnt[i] == max) {
                maxCnt++;
            }
        }

        if (maxCnt == 1) {
            System.out.println((char) (maxIdx + 'A'));
        } else {
            System.out.println("?");
        }
    }
}
