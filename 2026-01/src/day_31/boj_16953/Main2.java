package day_31.boj_16953;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean flag = false;
        int cnt = 1;
        while (true) {
            if (a == b) {
                flag = true;
                break;
            } else if (a > b) {
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                break;
            }

            cnt++;
        }

        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
