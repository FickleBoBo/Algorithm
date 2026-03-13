package day_21.boj_5598;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (c <= 'C') {
                sb.append((char) (c - 3 + 26));
            } else {
                sb.append((char) (c - 3));
            }
        }

        System.out.println(sb);
    }
}
