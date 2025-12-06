package day_06.boj_5086;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0) break;

            if (A % B == 0) {
                bw.write("multiple\n");
            } else if (B % A == 0) {
                bw.write("factor\n");
            } else {
                bw.write("neither\n");
            }
        }

        bw.flush();
    }
}
