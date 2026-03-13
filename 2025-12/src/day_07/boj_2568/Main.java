package day_07.boj_2568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        List<Integer> dp = new ArrayList<>();

        int[] pos = new int[n];
        int[] prv = new int[n];
        Arrays.fill(prv, -1);

        for (int i = 0; i < n; i++) {
            int x = map[i][0];
            int idx = lowerBound(dp, x);

            if (idx == dp.size()) {
                dp.add(x);
            } else {
                dp.set(idx, x);
            }

            pos[idx] = i;
            if (idx > 0) prv[i] = pos[idx - 1];
        }

        System.out.println(n - dp.size());
        System.out.println(traceback(map, prv, pos[dp.size() - 1]));
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

    static String traceback(int[][] map, int[] prv, int pos) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < map.length; i++) {
            set.add(map[i][0]);
        }

        while (pos != -1) {
            set.remove(map[pos][0]);
            pos = prv[pos];
        }

        for (int x : set) {
            sb.append(x).append("\n");
        }

        return sb.toString();
    }
}
