package day_06.boj_25192;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(input);
            }
        }
        cnt += set.size();

        System.out.println(cnt);
    }
}
