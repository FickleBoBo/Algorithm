package day_17.boj_1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> tset = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tset.add(br.readLine());
        }

        Set<String> hset = new HashSet<>();
        for (int i = 0; i < m; i++) {
            hset.add(br.readLine());
        }

        tset.retainAll(hset);

        sb.append(tset.size()).append("\n");
        for (String str : tset) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
