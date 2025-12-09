package day_09.boj_1522;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int len = 0;  // 윈도우 크기
        for (char c : str) {
            if (c == 'a') len++;
        }

        int cnt = 0;  // 초기 윈도우 내 a의 개수
        for (int i = 0; i < len; i++) {
            if (str[i] == 'a') cnt++;
        }

        int max = cnt;  // 윈도우 내 a의 개수가 가장 많은 경우
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a') cnt--;
            if (str[(i + len) % str.length] == 'a') cnt++;

            max = Math.max(max, cnt);
        }

        // 윈도우 내 a의 개수가 가장 많을 때 윈도우 내 b와 윈도우 밖 a를 교환하면 a로 연속되게 교환 가능
        System.out.println(len - max);
    }
}
