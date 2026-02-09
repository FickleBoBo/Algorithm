package day_07.boj_20920;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt) return Integer.compare(o.cnt, this.cnt);
            if (this.str.length() != o.str.length()) return Integer.compare(o.str.length(), this.str.length());
            return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<Node> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        list.sort(Comparator.naturalOrder());

        for (Node node : list) {
            bw.write(node.str);
            bw.newLine();
        }

        bw.flush();
    }
}
