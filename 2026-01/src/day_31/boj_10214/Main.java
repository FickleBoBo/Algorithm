package day_31.boj_10214;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int sumY = 0;
            int sumK = 0;

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                sumY += y;
                sumK += k;
            }

            if (sumY > sumK) {
                bw.write("Yonsei\n");
            } else if (sumY < sumK) {
                bw.write("Korea\n");
            } else {
                bw.write("Draw\n");
            }
        }

        bw.flush();
    }
}
