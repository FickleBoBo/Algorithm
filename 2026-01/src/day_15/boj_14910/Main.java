package day_15.boj_14910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = -1_000_000;
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (x >= prev) {
                prev = x;
            } else {
                System.out.println("Bad");
                return;
            }
        }

        System.out.println("Good");
    }
}
