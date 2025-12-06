package day_05.boj_3052;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());

            set.add(num % 42);
        }

        System.out.println(set.size());
    }
}
