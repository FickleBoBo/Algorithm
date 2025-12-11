package day_08.boj_5073;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] sides = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(sides);

            if (sides[0] == 0) break;

            if (sides[0] + sides[1] <= sides[2]) {
                bw.write("Invalid\n");
            } else {
                if (sides[0] == sides[1] && sides[1] == sides[2]) {
                    bw.write("Equilateral\n");
                } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[2] == sides[0]) {
                    bw.write("Isosceles\n");
                } else {
                    bw.write("Scalene\n");
                }
            }
        }

        bw.flush();
    }
}
