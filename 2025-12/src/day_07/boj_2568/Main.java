package day_07.boj_2568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        List<Integer> dp = new ArrayList<>();

        int[] pos = new int[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            int num = map[i][0];
            int idx = lowerBound(dp, num);

            if (idx == dp.size()) {
                dp.add(num);
            } else {
                dp.set(idx, num);
            }

            pos[idx] = i;
            if (idx > 0) prev[i] = pos[idx - 1];
        }

        sb.append(N - dp.size()).append("\n");
        sb.append(traceback(map, prev, pos[dp.size() - 1]));

        System.out.println(sb);
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

    static String traceback(int[][] map, int[] prev, int pos) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < map.length; i++) {
            set.add(map[i][0]);
        }

        while (pos != -1) {
            set.remove(map[pos][0]);
            pos = prev[pos];
        }

        for (int num : set) {
            sb.append(num).append("\n");
        }

        return sb.toString();
    }
}
