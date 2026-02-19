package day_06.boj_2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x = 1;

        while ((3 * x * (x - 1) + 1) < n) {
            x++;
        }

        System.out.println(x);
    }
}
