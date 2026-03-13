package day_27.boj_11944;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s = String.valueOf(n).repeat(n);

        System.out.println(s.substring(0, Math.min(s.length(), m)));
    }
}
