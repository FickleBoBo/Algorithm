package day_14.boj_4458;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            bw.write(Character.toUpperCase(str.charAt(0)));
            bw.write(str.substring(1));
            bw.newLine();
        }

        bw.flush();
    }
}
