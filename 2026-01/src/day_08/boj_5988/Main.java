package day_08.boj_5988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String K = br.readLine();

            if ((K.charAt(K.length() - 1) - '0') % 2 == 0) {
                bw.write("even\n");
            } else {
                bw.write("odd\n");
            }
        }

        bw.flush();
    }
}
