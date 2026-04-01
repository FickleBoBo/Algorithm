package day_07.boj_4153;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(arr);

            if (arr[0] == 0) break;

            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }

        bw.flush();
    }
}
