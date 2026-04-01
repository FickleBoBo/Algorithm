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
        while (n-- > 0) {
            tset.add(br.readLine());
        }

        Set<String> hset = new HashSet<>();
        while (m-- > 0) {
            hset.add(br.readLine());
        }

        tset.retainAll(hset);

        sb.append(tset.size()).append("\n");
        for (String s : tset) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
