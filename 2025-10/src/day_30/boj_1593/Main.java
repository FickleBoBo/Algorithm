package day_30.boj_1593;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());  // 단어 W의 길이
        int len = Integer.parseInt(st.nextToken());  // 문자열 S의 길이

        char[] W = br.readLine().toCharArray();
        int[] checkW = new int[58];  // 단어 W에 등장한 알파벳을 세는 카운팅 배열
        for (char c : W) {
            checkW[c - 'A']++;
        }

        char[] S = br.readLine().toCharArray();
        int[] checkS = new int[58];  // 단어 S의 윈도우 내에 등장한 알파벳을 세는 카운팅 배열
        for (int i = 0; i < g; i++) {
            checkS[S[i] - 'A']++;
        }

        int cnt = 0;

        // 초기 윈도우에서 W를 만족하면 카운팅
        if (isPossible(checkW, checkS)) {
            cnt++;
        }

        // 윈도우를 이동하며 W를 만족하면 카운팅
        for (int i = 0; i < len - g; i++) {
            checkS[S[i] - 'A']--;
            checkS[S[i + g] - 'A']++;

            if (isPossible(checkW, checkS)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    // 두 카운팅 배열의 각 원소가 모두 일치하면 순열로 W를 만들 수 있음
    private static boolean isPossible(int[] checkW, int[] checkS) {
        for (int i = 0; i < 58; i++) {
            if (checkW[i] != checkS[i]) return false;
        }

        return true;
    }
}
