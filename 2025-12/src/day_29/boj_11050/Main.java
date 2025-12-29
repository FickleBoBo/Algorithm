package day_29.boj_11050;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(nCr(N, K));
    }

    static int nCr(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (r == 1) return n;

        return nCr(n - 1, r) + nCr(n - 1, r - 1);
    }
}
