package day_20.boj_1071;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static int[] cnt = new int[1 + MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        int prv = -2;
        while (true) {
            int idx = -1;
            for (int i = 0; i <= MAX; i++) {
                if (i != prv + 1 && cnt[i] != 0) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) break;

            int idx2 = -1;
            for (int i = 0; i <= MAX; i++) {
                if (i != idx && i != idx + 1 && cnt[i] != 0) {
                    idx2 = i;
                    break;
                }
            }

            if (idx2 != -1) {
                sb.append(idx).append(" ");
                cnt[idx]--;
                prv = idx;
            } else {
                if (idx < MAX && cnt[idx + 1] > 0) {
                    sb.append(idx + 1).append(" ");
                    cnt[idx + 1]--;
                } else {
                    sb.append(idx).append(" ");
                    cnt[idx]--;
                }
            }
        }

        System.out.println(sb);
    }
}
