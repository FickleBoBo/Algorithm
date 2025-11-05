package day_05.boj_7977;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        // 알파벳에 대한 카운팅 배열
        int[] cntArr = new int[26];
        for (char c : str) {
            cntArr[c - 'A']++;
        }

        int min = Math.min(Math.min(cntArr[0], cntArr[2]), Math.min(cntArr[6], cntArr[19]));

        System.out.println(min);
        System.out.println(getDNA(N, cntArr, min));
    }

    private static String getDNA(int N, int[] cntArr, int min) {
        if (cntArr[0] == min) return "A".repeat(N);
        if (cntArr[2] == min) return "C".repeat(N);
        if (cntArr[6] == min) return "G".repeat(N);
        return "T".repeat(N);
    }
}
