package day_06.boj_10815;

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

        boolean[] visited = new boolean[MAX + 1 + MAX];  // 음수도 커버하는 방문 체크 배열
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            visited[Integer.parseInt(st.nextToken()) + MAX] = true;
        }

        br.readLine();  // M 입력값은 버림

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (visited[Integer.parseInt(st.nextToken()) + MAX]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
