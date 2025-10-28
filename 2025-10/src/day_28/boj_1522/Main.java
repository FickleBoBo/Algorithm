package day_28.boj_1522;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        int len = 0;  // 윈도우 크기

        for (char c : str) {
            if (c == 'b') len++;
        }

        int cnt = 0;  // 초기 윈도우 내 b의 개수
        for (int i = 0; i < len; i++) {
            if (str[i] == 'b') cnt++;
        }

        int max = cnt;  // 윈도우 내 b의 개수가 가장 많은 경우
        for (int i = 0; i < str.length + len; i++) {
            if (str[i % str.length] == 'b') cnt--;
            if (str[(i + len) % str.length] == 'b') cnt++;

            max = Math.max(max, cnt);
        }

        // 윈도우 내 b의 개수가 가장 많을 때 윈도우 내 a와 윈도우 밖 b를 교환하면 b로 연속되게 교환 가능
        System.out.println(len - max);
    }
}
