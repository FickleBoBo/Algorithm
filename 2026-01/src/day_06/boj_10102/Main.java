package day_06.boj_10102;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;
        int v = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < v; i++) {
            if (str.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }

        if (a > b) {
            System.out.println("A");
        } else if (a < b) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}
