package day_06.boj_11365;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals("END")) break;

            bw.write(new StringBuilder(line).reverse().toString());
            bw.newLine();
        }

        bw.flush();
    }
}
