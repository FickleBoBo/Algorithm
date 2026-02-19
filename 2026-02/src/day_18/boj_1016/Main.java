package day_18.boj_1016;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];
        Arrays.fill(check, true);

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long q = min % pow == 0 ? min / pow : min / pow + 1;

            for (long j = pow * q; j <= max; j += pow) {
                check[(int) (j - min)] = false;
            }
        }

        int cnt = 0;
        for (boolean flag : check) {
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
