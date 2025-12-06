package day_05.boj_14215;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max = Math.max(a, Math.max(b, c));
        int left = a + b + c - max;

        if (max < left) {
            System.out.println(a + b + c);
        } else {
            System.out.println(2 * left - 1);
        }
    }
}
