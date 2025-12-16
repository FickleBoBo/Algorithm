package day_16.boj_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());
            return o1.compareTo(o2);
        });

        String prev = "";
        for (String str : arr) {
            if (str.equals(prev)) continue;

            bw.write(str);
            bw.newLine();
            prev = str;
        }

        bw.flush();
    }
}
