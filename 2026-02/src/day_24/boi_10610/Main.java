package day_24.boi_10610;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int sum = 0;
        boolean has0 = false;

        for (char c : str.toCharArray()) {
            sum += c - '0';
            if (c == '0') has0 = true;
        }

        if (sum % 3 == 0 && has0) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            for (char c : arr) {
                sb.append(c);
            }
            sb.reverse();
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
