package day_04.boj_10809;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        for (int i = 0; i < 26; i++) {
            sb.append(S.indexOf((char) (i + 'a'))).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
