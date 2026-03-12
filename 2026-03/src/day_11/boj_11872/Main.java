package day_11.boj_11872;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nimsum = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int p = Integer.parseInt(st.nextToken());

            if (p % 4 == 0) {
                nimsum ^= p - 1;
            } else if (p % 4 == 3) {
                nimsum ^= p + 1;
            } else {
                nimsum ^= p;
            }
        }

        if (nimsum != 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}
