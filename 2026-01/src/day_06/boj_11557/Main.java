package day_06.boj_11557;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        String name;
        int amount;

        public Node(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.amount, this.amount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(name, amount);
            }
            Arrays.sort(nodes);

            sb.append(nodes[0].name).append("\n");
        }

        System.out.print(sb);
    }
}
