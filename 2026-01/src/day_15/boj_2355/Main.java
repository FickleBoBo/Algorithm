package day_15.boj_2355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(((long) a + b) * ((long) b - a + 1) / 2);
    }
}
