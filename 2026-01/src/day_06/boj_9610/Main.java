package day_06.boj_9610;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] cntArr = new int[5];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                cntArr[0]++;
                continue;
            }

            if (x > 0) {
                if (y > 0) {
                    cntArr[1]++;
                } else {
                    cntArr[4]++;
                }
            } else {
                if (y > 0) {
                    cntArr[2]++;
                } else {
                    cntArr[3]++;
                }
            }
        }

        System.out.println("Q1: " + cntArr[1]);
        System.out.println("Q2: " + cntArr[2]);
        System.out.println("Q3: " + cntArr[3]);
        System.out.println("Q4: " + cntArr[4]);
        System.out.println("AXIS: " + cntArr[0]);
    }
}
