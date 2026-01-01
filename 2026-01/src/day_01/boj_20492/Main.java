package day_01.boj_20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((N / 100 * 78) + " " + (N / 100 * 80 + N / 100 * 78 * 20 / 100));
    }
}
