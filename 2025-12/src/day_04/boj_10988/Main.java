package day_04.boj_10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String revStr = new StringBuilder(str).reverse().toString();

        if (str.equals(revStr)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
