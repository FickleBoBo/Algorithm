package day_17.boj_11478;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                set.add(str.substring(i, j + 1));
            }
        }

        System.out.println(set.size());
    }
}
