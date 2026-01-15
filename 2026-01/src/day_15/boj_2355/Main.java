package day_15.boj_2355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A > B) {
            int tmp = A;
            A = B;
            B = tmp;
        }

        System.out.println(((long) A + B) * ((long) B - A + 1) / 2);
    }
}
