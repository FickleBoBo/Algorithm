package day_08.boj_1264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();

            if (line.equals("#")) break;

            int cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
