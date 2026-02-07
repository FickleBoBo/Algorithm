package day_05.boj_21867;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            if (c == 'J' || c == 'A' || c == 'V') continue;
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("nojava");
        } else {
            System.out.println(sb);
        }
    }
}
