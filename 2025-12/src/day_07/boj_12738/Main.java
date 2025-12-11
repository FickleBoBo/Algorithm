package day_07.boj_12738;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();
        for (int n : arr) {
            int idx = lowerBound(dp, n);

            if (idx == dp.size()) {
                dp.add(n);
            } else {
                dp.set(idx, n);
            }
        }

        System.out.println(dp.size());
    }

    static int lowerBound(List<Integer> list, int key) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
