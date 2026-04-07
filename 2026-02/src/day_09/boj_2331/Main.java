package day_09.boj_2331;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        int cur = a;

        while (true) {
            map.put(cur, idx);

            int nxt = 0;
            while (cur > 0) {
                int r = cur % 10;
                int tmp = 1;
                for (int i = 0; i < p; i++) {
                    tmp *= r;
                }

                nxt += tmp;
                cur /= 10;
            }

            if (map.containsKey(nxt)) {
                System.out.println(map.get(nxt) - 1);
                return;
            }

            idx++;
            cur = nxt;
        }
    }
}
