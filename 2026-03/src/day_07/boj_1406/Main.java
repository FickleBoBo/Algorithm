package day_07.boj_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Character> f = new ArrayDeque<>();
        Deque<Character> b = new ArrayDeque<>();

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            f.offerLast(c);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            if (c == 'L') {
                if (!f.isEmpty()) b.offerFirst(f.pollLast());
            } else if (c == 'D') {
                if (!b.isEmpty()) f.offerLast(b.pollFirst());
            } else if (c == 'B') {
                if (!f.isEmpty()) f.pollLast();
            } else {
                f.offerLast(st.nextToken().charAt(0));
            }
        }

        while (!f.isEmpty()) {
            sb.append(f.pollFirst());
        }
        while (!b.isEmpty()) {
            sb.append(b.pollFirst());
        }

        System.out.println(sb);
    }
}
