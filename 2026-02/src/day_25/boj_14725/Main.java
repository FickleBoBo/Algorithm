package day_25.boj_14725;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static final int MAX = 2 + 1000 * 15;
    static final int ROOT = 1;
    static int unused = ROOT + 1;
    static Map<String, Integer>[] nxt = new TreeMap[MAX];

    static {
        for (int i = 1; i < MAX; i++) {
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
            sb.append("--".repeat(depth)).append(entry.getKey()).append("\n");
            dfs(entry.getValue(), depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            String[] words = new String[k];
            for (int i = 0; i < k; i++) {
                words[i] = st.nextToken();
            }
            insert(words);
        }

        dfs(ROOT, 0);

        System.out.println(sb);
    }
}
