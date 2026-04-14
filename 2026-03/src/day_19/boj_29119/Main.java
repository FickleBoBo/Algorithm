package day_19.boj_29119;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String s : arr) {
            sb.append(s).append(" ");
        }

        System.out.println(sb);
    }
}
