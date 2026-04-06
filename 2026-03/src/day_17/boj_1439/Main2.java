package day_17.boj_1439;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int cnt0 = new StringTokenizer(s, "1").countTokens();
        int cnt1 = new StringTokenizer(s, "0").countTokens();

        System.out.println(Math.min(cnt0, cnt1));
    }
}
