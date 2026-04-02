package day_16.boj_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());
            return o1.compareTo(o2);
        });

        String prv = "";
        for (String s : arr) {
            if (s.equals(prv)) continue;

            bw.write(s);
            bw.newLine();
            prv = s;
        }

        bw.flush();
    }
}
