package day_20.boj_12904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();
        int len = t.length;

        while (len > s.length) {
            char c = t[len - 1];

            if (c == 'A') {
                len--;
            } else {
                len--;
                reverse(t, len);
            }
        }

        for (int i = 0; i < len; i++) {
            if (s[i] != t[i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    static void reverse(char[] arr, int len) {
        for (int i = 0; i < len / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = tmp;
        }
    }
}
