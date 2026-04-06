package day_28.boj_4999;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        if (s1.length() < s2.length()) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}
