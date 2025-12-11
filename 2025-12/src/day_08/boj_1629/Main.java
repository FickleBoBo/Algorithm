package day_08.boj_1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(modPow(A, B, C));
    }

    static long modPow(long A, long B, long C) {
        long res = 1;

        while (B > 0) {
            if ((B & 1) > 0) res = res * A % C;
            A = A * A % C;
            B >>= 1;
        }

        return res;
    }
}
