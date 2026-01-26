package day_18.boj_2083;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (name.equals("#") && age == 0 && weight == 0) break;

            if (age > 17 || weight >= 80) {
                sb.append(name).append(" Senior\n");
            } else {
                sb.append(name).append(" Junior\n");
            }
        }

        System.out.println(sb);
    }
}
