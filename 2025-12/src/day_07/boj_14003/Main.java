package day_07.boj_14003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();

        int[] pos = new int[n];
        int[] prv = new int[n];
        Arrays.fill(prv, -1);

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int idx = lowerBound(dp, x);

            if (idx == dp.size()) {
                dp.add(x);
            } else {
                dp.set(idx, x);
            }

            pos[idx] = i;
            if (idx > 0) prv[i] = pos[idx - 1];
        }

        System.out.println(dp.size());
        System.out.println(traceback(arr, prv, pos[dp.size() - 1]));
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

    static String traceback(int[] arr, int[] prv, int pos) {
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();
        while (pos != -1) {
            stack.push(arr[pos]);
            pos = prv[pos];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }
}
