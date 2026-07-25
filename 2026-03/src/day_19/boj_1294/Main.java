package day_19.boj_1294;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine() + "a";
        }

        int idx = 0;
        while (idx < n) {
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            sb.append(arr[0].charAt(0));

            arr[0] = arr[0].substring(1);
            if (arr[0].length() == 1) idx++;
        }

        System.out.println(sb);
    }
}
//AAABBBCCC DABCDAB CDABCDABCDABCDABCDABCDABDE
//AAABBBCCC DABCDAB DABCDABCDABCDABCDABCDABCDE
//AAABBBCCCDABCDABCDABCDABCDABCDABCDABCDABDE
//AAABBBCCCDABCDABCDABCDABCDABCDABCDABCDABDE

//DABC DAB
//DABC DABCDABCDE
//DABC DABCDABC