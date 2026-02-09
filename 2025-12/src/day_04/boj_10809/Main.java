package day_04.boj_10809;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for (int i = 0; i < 26; i++) {
            sb.append(str.indexOf((char) (i + 'a'))).append(" ");
        }

        System.out.println(sb);
    }
}
