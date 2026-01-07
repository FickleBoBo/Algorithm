package day_07.boj_26069;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if (set.contains(name1)) set.add(name2);
            if (set.contains(name2)) set.add(name1);
        }

        System.out.println(set.size());
    }
}
