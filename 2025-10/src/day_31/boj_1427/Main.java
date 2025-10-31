package day_31.boj_1427;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        // 역방향 조회로 내림차순 효과
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
