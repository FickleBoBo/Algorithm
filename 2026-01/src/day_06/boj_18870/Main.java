package day_06.boj_18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }

        List<Integer> xs = new ArrayList<>(set);
        xs.sort(Comparator.naturalOrder());

        for (int n : arr) {
            sb.append(Collections.binarySearch(xs, n)).append(" ");
        }

        System.out.println(sb);
    }
}
