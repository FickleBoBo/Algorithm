package day_26.boj_10797;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (n == x) cnt++;
        }

        System.out.println(cnt);
    }
}
