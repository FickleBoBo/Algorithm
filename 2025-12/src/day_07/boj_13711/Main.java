package day_07.boj_13711;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[][] b = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i][0] = Integer.parseInt(st.nextToken());
            b[i][1] = i;
        }
        Arrays.sort(b, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = b[a[i] - 1][1];
        }

        List<Integer> dp = new ArrayList<>();
        for (int x : arr) {
            int idx = lowerBound(dp, x);

            if (idx == dp.size()) {
                dp.add(x);
            } else {
                dp.set(idx, x);
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
