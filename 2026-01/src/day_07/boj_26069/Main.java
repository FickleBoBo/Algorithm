package day_07.boj_26069;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (set.contains(s1)) set.add(s2);
            if (set.contains(s2)) set.add(s1);
        }

        System.out.println(set.size());
    }
}
