package day_10.boj_11868;

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
            nimsum ^= Integer.parseInt(st.nextToken());
        }

        if (nimsum != 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}
