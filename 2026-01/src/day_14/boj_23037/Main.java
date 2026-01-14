package day_14.boj_23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int sum = 0;

        for (char c : str.toCharArray()) {
            int n = c - '0';
            sum += n * n * n * n * n;
        }

        System.out.println(sum);
    }
}
