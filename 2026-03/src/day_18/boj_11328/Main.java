package day_18.boj_11328;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            int[] cnt = new int[26];

            for (char c : s1.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (char c : s2.toCharArray()) {
                cnt[c - 'a']--;
            }

            boolean flag = true;
            for (int x : cnt) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }
        }

        bw.flush();
    }
}
