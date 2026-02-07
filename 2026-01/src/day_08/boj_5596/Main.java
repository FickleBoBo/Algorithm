package day_08.boj_5596;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum1 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sum1 += Integer.parseInt(st.nextToken());
        }

        int sum2 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sum2 += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(sum1, sum2));
    }
}
