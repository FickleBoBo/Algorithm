package day_28.boj_20437;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            char[] W = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            // key에 알파벳 소문자, value에 해당 알파벳의 인덱스를 담은 리스트를 갖는 Map
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < W.length; i++) {
                map.putIfAbsent(W[i], new ArrayList<>());
                map.get(W[i]).add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = 0;

            // 알파벳별 리스트에 대해 슬라이딩 윈도우 수행
            for (List<Integer> list : map.values()) {
                for (int i = 0; i < list.size() - K + 1; i++) {
                    min = Math.min(min, list.get(i + K - 1) - list.get(i) + 1);
                    max = Math.max(max, list.get(i + K - 1) - list.get(i) + 1);
                }
            }

            // min 값이 갱신되지 않은 경우로 판단
            if (min == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
