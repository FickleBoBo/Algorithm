package day_23.boj_10220;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 4) {
                System.out.println(2);
            } else if (n <= 3 || n == 6) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}
