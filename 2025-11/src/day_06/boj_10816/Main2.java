package day_06.boj_10816;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MAX = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        br.readLine();  // N 입력값은 버림

        int[] cntArr = new int[MAX + 1 + MAX];  // 음수도 커버하는 카운팅 배열
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cntArr[Integer.parseInt(st.nextToken()) + MAX]++;
        }

        br.readLine();  // M 입력값은 버림

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(cntArr[Integer.parseInt(st.nextToken()) + MAX]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
