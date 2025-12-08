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
        if (B == 0) return 1;

        long half = modPow(A, B / 2, C);

        if (B % 2 == 0) {
            return half * half % C;
        } else {
            return half * half % C * A % C;
        }
    }
}
