package day_15.boj_1011;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int diff = y - x;
            int num = 1;
            int cnt = 0;
            while (diff > 2 * num) {
                diff -= 2 * num;
                num++;
                cnt += 2;
            }
            if (diff > num) {
                cnt += 2;
            } else if (diff > 0) {
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
