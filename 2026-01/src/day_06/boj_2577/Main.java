package day_06.boj_2577;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        int[] cntArr = new int[10];

        while (result > 0) {
            cntArr[result % 10]++;
            result /= 10;
        }

        for (int cnt : cntArr) {
            System.out.println(cnt);
        }
    }
}
