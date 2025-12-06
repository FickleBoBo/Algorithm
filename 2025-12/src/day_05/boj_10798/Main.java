package day_05.boj_10798;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[][] grid = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (grid[i][j] != '\u0000') sb.append(grid[i][j]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
