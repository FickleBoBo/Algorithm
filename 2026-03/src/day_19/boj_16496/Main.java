package day_19.boj_16496;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) {
            System.out.println(0);
        } else {
            for (String s : arr) {
                sb.append(s);
            }

            System.out.println(sb);
        }
    }
}
