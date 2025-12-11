package day_09.boj_12891;

import java.io.*;
import java.util.*;

public class Main {

    // 알파벳과 인덱스 매핑
    static Map<Character, Integer> map = Map.of(
            'A', 0,
            'C', 1,
            'G', 2,
            'T', 3
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();

        int[] cntArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cntArr[i] = Integer.parseInt(st.nextToken());
        }

        // 만들 수 있는 비밀번호의 종류의 수
        int cnt = 0;

        // 초기 윈도우에 대해 카운팅 배열 갱신
        for (int i = 0; i < P; i++) {
            cntArr[map.get(str[i])]--;
        }

        // 초기 윈도우로 만들 수 있는 비밀번호면 카운팅
        if (isPossible(cntArr)) {
            cnt++;
        }

        for (int i = 0; i < S - P; i++) {
            // 윈도우 이동
            cntArr[map.get(str[i])]++;
            cntArr[map.get(str[i + P])]--;

            // 이동 후 만들 수 있는 비밀번호면 카운팅
            if (isPossible(cntArr)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isPossible(int[] arr) {
        for (int n : arr) {
            if (n > 0) return false;
        }
        return true;
    }
}
