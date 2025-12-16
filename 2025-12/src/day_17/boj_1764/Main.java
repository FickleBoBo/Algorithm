package day_17.boj_1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);

        sb.append(set1.size()).append("\n");
        for (String str : set1) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
