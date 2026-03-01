package day_25.boj_5670;

import java.io.*;

public class Main {

    static class Trie {

        static class Node {
            Node[] children = new Node[26];
            boolean isEnd;
            int cnt;  // 자식 노드의 수
        }

        Node root = new Node();

        void insert(String s) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Node();
                    cur.cnt++;
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }

        void solve() {
            solve(root, 0);
        }

        void solve(Node cur, int value) {
            if (cur.isEnd) {
                sum += value;
            }

            for (Node nxt : cur.children) {
                if (nxt == null) continue;

                if (cur == root || cur.isEnd || cur.cnt > 1) {
                    solve(nxt, value + 1);
                } else {
                    solve(nxt, value);
                }
            }
        }
    }

    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            Trie trie = new Trie();
            sum = 0;

            int n = Integer.parseInt(line);
            for (int i = 0; i < n; i++) {
                trie.insert(br.readLine());
            }

            trie.solve();
            System.out.printf("%.2f\n", (double) sum / n);
        }
    }
}
