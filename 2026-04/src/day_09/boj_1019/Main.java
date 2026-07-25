package day_09.boj_1019;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int[] cnt = new int[10];

        for (int i = n.length() - 1; i >= 0; i--) {
            String front = n.substring(0, i);
            int x = n.charAt(i) - '0';
            String back = n.substring(i + 1);

            if (!front.isEmpty() && !back.isEmpty()) {
                int q = 1;
                for (int k = 1; k <= back.length(); k++) {
                    q *= 10;
                }

                cnt[0] += (Integer.parseInt(front) - 1) * q;
                for (int j = 1; j < 10; j++) {
                    cnt[j] += Integer.parseInt(front) * q;
                }
                for (int j = 0; j < x; j++) {
                    cnt[j] += q;
                }
                cnt[x] += Integer.parseInt(back) + 1;
            } else if (!front.isEmpty()) {
                for (int j = 0; j < 10; j++) {
                    cnt[j] += Integer.parseInt(front);
                }
                for (int j = 0; j <= x; j++) {
                    cnt[j]++;
                }
                cnt[0]--;
            } else if (!back.isEmpty()) {
                int q = 1;
                for (int k = 1; k <= back.length(); k++) {
                    q *= 10;
                }

                for (int j = 1; j < x; j++) {
                    cnt[j] += q;
                }
                cnt[x] += Integer.parseInt(back) + 1;
            } else {
                for (int j = 1; j <= x; j++) {
                    cnt[j]++;
                }
            }

//            System.out.println(Arrays.toString(cnt));
        }

//        System.out.println(Arrays.toString(cnt));

        for (int i = 0; i < 10; i++) {
            System.out.print(cnt[i] + " ");
        }

        // 429904664 541008121 540917467 540117067 533117017 473117011 429904664 429904664 429904664 429904664
        // 429904664 541008121 540917467 540117067 533117017 473117011 429904664 429904664 429904664 429904664
    }
}
// 9734
// 10xx
// 90xx
