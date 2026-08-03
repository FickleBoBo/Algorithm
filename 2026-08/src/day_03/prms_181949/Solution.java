package day_03.prms_181949;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (char c : br.readLine().toCharArray()) {
            if ('a' <= c && c <= 'z') {
                sb.append((char) (c - 'a' + 'A'));
            } else {
                sb.append((char) (c - 'A' + 'a'));
            }
        }

        System.out.println(sb);
    }
}
