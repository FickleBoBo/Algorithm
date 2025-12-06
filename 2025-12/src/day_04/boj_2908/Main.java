package day_04.boj_2908;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String revA = new StringBuilder(st.nextToken()).reverse().toString();
        String revB = new StringBuilder(st.nextToken()).reverse().toString();

        System.out.println(Math.max(Integer.parseInt(revA), Integer.parseInt(revB)));
    }
}
