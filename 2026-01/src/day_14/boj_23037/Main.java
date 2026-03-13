package day_14.boj_23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sum = 0;

        for (char c : s.toCharArray()) {
            int x = c - '0';
            sum += x * x * x * x * x;
        }

        System.out.println(sum);
    }
}
