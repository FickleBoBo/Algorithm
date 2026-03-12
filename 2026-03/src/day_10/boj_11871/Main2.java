package day_10.boj_11871;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nimsum = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int p = Integer.parseInt(st.nextToken());
            if (p % 2 == 0) {
                nimsum ^= p / 2 - 1;
            } else {
                nimsum ^= (p + 1) / 2;
            }
        }

        if (nimsum != 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}
