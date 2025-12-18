package day_18.boj_1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(String.valueOf(i), name);
            map.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            bw.write(map.get(command));
            bw.newLine();
        }

        bw.flush();
    }
}
