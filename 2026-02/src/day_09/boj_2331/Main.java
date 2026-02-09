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

            int next = 0;
            while (cur > 0) {
                int r = cur % 10;
                int tmp = 1;
                for (int i = 0; i < p; i++) {
                    tmp *= r;
                }

                next += tmp;
                cur /= 10;
            }

            if (map.containsKey(next)) {
                System.out.println(map.get(next) - 1);
                return;
            }

            idx++;
            cur = next;
        }
    }
}
