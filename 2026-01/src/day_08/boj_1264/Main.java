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
            for (char c : line.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
