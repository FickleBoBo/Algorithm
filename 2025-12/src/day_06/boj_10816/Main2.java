package day_06.boj_10816;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MAX = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        br.readLine();
        int[] cntArr = new int[MAX + 1 + MAX];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cntArr[Integer.parseInt(st.nextToken()) + MAX]++;
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(cntArr[Integer.parseInt(st.nextToken()) + MAX]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
