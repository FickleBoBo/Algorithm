package day_18.boj_1436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int x = 666;
        while (true) {
            if (String.valueOf(x).contains("666")) {
                n--;

                if (n == 0) break;
            }
            x++;
        }

        System.out.println(x);
    }
}
