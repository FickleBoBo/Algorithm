package day_27.boj_7432;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static final int MX = 1 + 500 * 80;
    static final int ROOT = 0;
    static int unused = ROOT + 1;
    static Map<String, Integer>[] nxt = new TreeMap[MX];

    static {
        for (int i = 0; i < MX; i++) {
            nxt[i] = new TreeMap<>();
        }
    }

    static void insert(String[] words) {
        int cur = ROOT;
        for (String word : words) {
            if (!nxt[cur].containsKey(word)) nxt[cur].put(word, unused++);
            cur = nxt[cur].get(word);
        }
    }

    static void dfs(int cur, int depth) {
        for (Map.Entry<String, Integer> entry : nxt[cur].entrySet()) {
            sb.append(" ".repeat(depth)).append(entry.getKey()).append("\n");
            dfs(entry.getValue(), depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] words = br.readLine().split("\\\\");
            insert(words);
        }

        dfs(ROOT, 0);

        System.out.println(sb);
    }
}
