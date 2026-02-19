package day_10.boj_33557;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            String s1 = String.valueOf(Long.parseLong(a) * Long.parseLong(b));

            int len = Math.max(a.length(), b.length());
            int[] arrA = toArr(Integer.parseInt(a), len);
            int[] arrB = toArr(Integer.parseInt(b), len);

            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < len; i++) {
                tmp.append(arrA[i] * arrB[i]);
            }

            String s2 = tmp.toString();

            if (s1.equals(s2)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }

    static int[] toArr(int x, int len) {
        int[] arr = new int[len];
        int idx = len - 1;

        while (x > 0) {
            arr[idx--] = x % 10;
            x /= 10;
        }

        while (idx >= 0) {
            arr[idx--] = 1;
        }

        return arr;
    }
}
