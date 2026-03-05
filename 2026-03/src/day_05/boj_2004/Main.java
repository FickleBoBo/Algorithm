package day_05.boj_2004;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt2 = find(n, 2) - find(m, 2) - find(n - m, 2);
        int cnt5 = find(n, 5) - find(m, 5) - find(n - m, 5);
        System.out.println(Math.min(cnt2, cnt5));
    }

    static int find(int x, int div) {
        int cnt = 0;

        long tmp = div;
        while (x >= tmp) {
            cnt += (int) (x / tmp);
            tmp *= div;
        }

        return cnt;
    }
}
