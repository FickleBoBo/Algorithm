package day_19.boj_3034;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x * x <= w * w + h * h) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}
