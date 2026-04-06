package day_15.boj_1259;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            if (s.equals(new StringBuilder(s).reverse().toString())) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }
}
