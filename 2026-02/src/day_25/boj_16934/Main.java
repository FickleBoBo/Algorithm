package day_25.boj_16934;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 1 + 100000 * 10;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static int[][] nxt = new int[MX][26];
    static Map<String, Integer> map = new HashMap<>();  // key를 닉네임으로 가입한 유저의 수(value)

    static void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
            cur = nxt[cur][idx];
        }
    }

    static String find(String s) {
        StringBuilder prefix = new StringBuilder();
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            prefix.append(c);
            int idx = c - 'a';
            if (nxt[cur][idx] == 0) return prefix.toString();
            cur = nxt[cur][idx];
        }

        if (map.containsKey(s)) prefix.append(map.get(s) + 1);
        return prefix.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();

            sb.append(find(s)).append("\n");
            insert(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println(sb);
    }
}
