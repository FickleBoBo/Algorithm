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

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();

        int[] cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        // 만들 수 있는 비밀번호의 종류의 수
        int result = 0;

        // 초기 윈도우에 대해 카운팅 배열 갱신
        for (int i = 0; i < p; i++) {
            cnt[map.get(str[i])]--;
        }

        // 초기 윈도우로 만들 수 있는 비밀번호면 카운팅
        if (isPossible(cnt)) {
            result++;
        }

        for (int i = 0; i < s - p; i++) {
            // 윈도우 이동
            cnt[map.get(str[i])]++;
            cnt[map.get(str[i + p])]--;

            // 이동 후 만들 수 있는 비밀번호면 카운팅
            if (isPossible(cnt)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isPossible(int[] arr) {
        for (int n : arr) {
            if (n > 0) return false;
        }
        return true;
    }
}
