package day_18.boj_1919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];

        String s1 = br.readLine();
        String s2 = br.readLine();

        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            cnt[c - 'a']--;
        }

        int ans = 0;
        for (int x : cnt) {
            ans += Math.abs(x);
        }

        System.out.println(ans);
    }
}
