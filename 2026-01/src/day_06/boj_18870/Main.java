package day_06.boj_18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        List<Integer> xs = new ArrayList<>(set);
        xs.sort(Comparator.naturalOrder());

        for (int x : arr) {
            sb.append(Collections.binarySearch(xs, x)).append(" ");
        }

        System.out.println(sb);
    }
}
