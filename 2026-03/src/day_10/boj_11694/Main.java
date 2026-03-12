package day_10.boj_11694;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nimsum = 0;
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            nimsum ^= p;
            if (p == 1) cnt++;
        }

        if ((cnt < n && nimsum != 0) || (cnt == n && cnt % 2 == 0)) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}
