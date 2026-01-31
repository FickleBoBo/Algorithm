package day_31.boj_16953;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean flag = false;
        int cnt = 1;
        while (true) {
            if (A == B) {
                flag = true;
                break;
            } else if (A > B) {
                break;
            }

            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
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
