package day_17.boj_1439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int cnt0 = 0;
        int cnt1 = 0;
        char prv = '\u0000';

        for (char c : s.toCharArray()) {
            if (c != prv) {
                if (c == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }

            prv = c;
        }

        System.out.println(Math.min(cnt0, cnt1));
    }
}
