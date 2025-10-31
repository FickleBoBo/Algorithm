package day_31.boj_1094;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int bit = 1; bit <= X; bit <<= 1) {
            if ((X & bit) > 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
