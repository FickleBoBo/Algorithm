package day_04.boj_2530;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());

        C += D;

        B += C / 60;
        C %= 60;

        A += B / 60;
        B %= 60;

        A %= 24;

        System.out.println(A + " " + B + " " + C);
    }
}
