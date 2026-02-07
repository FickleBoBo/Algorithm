package day_02.boj_28113;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a < Math.max(n, b)) {
            System.out.println("Bus");
        } else if (a > Math.max(n, b)) {
            System.out.println("Subway");
        } else {
            System.out.println("Anything");
        }
    }
}
